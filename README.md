🧩 Activité Pratique : Injection de Dépendances & Mini Framework IoC
🎯 Objectif du projet

Ce projet a pour objectif de :

Comprendre l’Inversion de Contrôle (IoC)
Implémenter l’Injection de Dépendances (DI)
Réduire le couplage entre les composants
Expérimenter différentes techniques d’injection
Concevoir un mini framework similaire à Spring IoC
Gérer l’injection via XML et Annotations
🧱 Partie 1 : Injection de dépendances (Spring / Java)
📌 Étapes réalisées
Création de l’interface IDao
Implémentation DaoImpl et DaoImplV2
Création de l’interface IMetier
Implémentation MetierImpl avec couplage faible
Mise en place des différentes techniques d’injection
⚙️ Types d’injection
🔹 a) Injection statique (Pres1)

👉 Instanciation directe avec new
❌ Couplage fort

 ![capture 1](Captures/1.png)

🔹 b) Injection dynamique (Pres2)

👉 Utilisation de la réflexion (Class.forName)
✔ Couplage réduit

![capture 2](Captures/2.png)

🔹 c) Injection avec Spring XML

👉 Configuration via fichier XML Spring

![capture 3](Captures/3.png)

🔹 d) Injection avec Spring Annotations

👉 Utilisation de @Component, @Autowired

![capture 4](Captures/4.png)

🔹 Test Annotations

![capture 5](Captures/5.png)

🔹 Test XML

![capture 6](Captures/6.png)

📁 Structure du projet Partie 1
ma.raf.partie1.ioc
│
├── dao
│   ├── IDao
│   ├── DaoImpl
│   └── DaoImplV2
│
├── metier
│   ├── IMetier
│   └── MetierImpl
│
└── pres
    ├── Pres1
    ├── Pres2
    ├── PresSpringXML
    ├── PresSpringAnnotation
    ├── TestAnnotations
    └── TestXmlPartie1
🧱 Partie 2 : Mini Framework d’Injection de Dépendances (IoC)
🎯 Objectif

Développer un mini framework d’injection de dépendances similaire à Spring IoC permettant :

Injection via XML
Injection via Annotations
Injection via :
Constructeur
Setter
Attribut (Field Injection)
⚙️ Fonctionnalités du framework

✔ Conteneur IoC personnalisé (ApplicationContext)
✔ Injection automatique des dépendances
✔ Support des interfaces
✔ Résolution des dépendances par réflexion
✔ Support XML (constructor-arg)
✔ Support annotations @InjectMe

🧠 Techniques implémentées
🔹 Injection par attribut
@InjectMe
private IDao dao;
🔹 Injection par constructeur
public MetierImpl(IDao dao)
🔹 Injection par setter
public void setDao(IDao dao)
📄 Configuration XML
<beans>
    <bean id="dao" class="ma.raf.partie2.framework.dao.DaoImpl"/>

    <bean id="metier" class="ma.raf.partie2.framework.metier.MetierImpl">
        <constructor-arg ref="dao"/>
    </bean>
</beans>
🧪 Résultat

![capture 7](Captures/7.png)

📁 Structure du projet Partie 2
ma.raf.partie2.framework
│
├── annotation
│   └── InjectMe
│
├── dao
│   └── DaoImpl
│
├── metier
│   └── MetierImpl
│
├── context
│   └── ApplicationContext
│
└── test
    └── Test
🚀 Résultat final

✔ Injection des dépendances fonctionnelle
✔ Mini framework IoC opérationnel
✔ Support XML + Annotations
✔ Support Constructor / Setter / Field injection

🧾 Consignes respectées

✔ Projet basé sur vidéos
👉 https://www.youtube.com/watch?v=vOLqabN-n2k

📌 Conclusion

Ce projet permet de comprendre le fonctionnement interne de Spring IoC en reproduisant :

Le conteneur de beans
L’injection de dépendances
La gestion XML et annotations
La réduction du couplage
👤 Réalisé par

RAFIK Bouchra

👨‍🏫 Encadré par

Mohamed Youssfi

📘 Projet

Activité Pratique : Injection de Dépendances & Mini Framework IoC

📅 Année académique

2025 / 2026