package ma.raf.partie2.framework.context;

import ma.raf.partie2.framework.annotation.InjectMe;

import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {

    private Map<Class<?>, Object> objects = new HashMap<>();

    public ApplicationContext(Class<?>[] classes) {

        try {
            // 1️⃣ création des objets
            for (Class<?> c : classes) {

                Object instance;

                // injection par constructeur
                Constructor<?>[] constructors = c.getConstructors();

                if (constructors.length > 0 && constructors[0].getParameterCount() > 0) {
                    Constructor<?> constructor = constructors[0];

                    Object[] params = resolveParams(constructor.getParameterTypes());

                    instance = constructor.newInstance(params);
                } else {
                    instance = c.getDeclaredConstructor().newInstance();
                }

                // stocker la classe
                objects.put(c, instance);

                // mapper interfaces
                for (Class<?> i : c.getInterfaces()) {
                    objects.put(i, instance);
                }
            }

            // 2️⃣ injection fields + setters
            for (Object obj : objects.values()) {

                injectFields(obj);   // injection attribut
                injectSetters(obj);  // injection setter
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    // 🔹 Injection par attribut

    private void injectFields(Object obj) throws Exception {

        for (Field field : obj.getClass().getDeclaredFields()) {

            if (field.isAnnotationPresent(InjectMe.class)) {

                Object dependency = objects.get(field.getType());

                if (dependency == null) {
                    throw new RuntimeException("Aucune implémentation pour " + field.getType());
                }

                field.setAccessible(true);
                field.set(obj, dependency);
            }
        }
    }


    // 🔹 Injection par setter

    private void injectSetters(Object obj) throws Exception {

        for (Method method : obj.getClass().getMethods()) {

            if (method.getName().startsWith("set")
                    && method.getParameterCount() == 1) {

                Object dependency = objects.get(method.getParameterTypes()[0]);

                if (dependency != null) {
                    method.invoke(obj, dependency);
                }
            }
        }
    }


    // 🔹 Résolution constructeur

    private Object[] resolveParams(Class<?>[] types) {

        Object[] params = new Object[types.length];

        for (int i = 0; i < types.length; i++) {
            params[i] = objects.get(types[i]);
        }

        return params;
    }


    // 🔹 getBean

    public <T> T getBean(Class<T> type) {
        return (T) objects.get(type);
    }
}