# Como Agregar datos a Firestore

## Example

```kotlin
        val firebaseFirestore = FirebaseFirestore.getInstance()

        for (i in 0 until jsonArr.length()) {
            val aux = jsonArr.get(i) as JSONObject
            var speaker = Speaker()
            speaker.name = aux.getString("name")
            speaker.jobtitle = aux.getString("jobtitle")
            speaker.workplace = aux.getString("workplace")
            speaker.biography = aux.getString("biography")
            speaker.twitter = aux.getString("twitter")
            speaker.image = aux.getString("image")
            speaker.category = aux.getInt("category")

            firebaseFirestore.collection("speakers").document().set(speaker)

        }
        for (i in 0 until jsonArr2.length()) {
            val aux = jsonArr2.get(i) as JSONObject
            var conference = Conference()
            conference.title = aux.getString("title")
            conference.description = aux.getString("description")
            conference.tag = aux.getString("tag")
            val cal = Calendar.getInstance()
            cal.timeInMillis = aux.getLong("datetime") * 1000
            conference.dateTime = cal.time
            conference.speaker = aux.getString("speaker")

            firebaseFirestore.collection("conferences").document().set(conference)
        }
```

## Example data

```kotlin


        val jsonArr = JSONArray("[\n" +
                "            {\n" +
                "                'biography' : 'Cesar Fajardo, creativo y content creator del equipo de Platzi, transforma las ideas en historias inspiradoras y contenidos innovadores que impactan al mundo para generar gracias, no solo likes, de nada sirve tu talento si no estas haciendo algo con el, de nada sirven tus habilidades si no tienes ideas para fusionarlas.',\n" +
                "                'category' : 5,\n" +
                "                'image' : 'https://pbs.twimg.com/profile_images/1015273976438902784/T0gZSbTP_400x400.jpg',\n" +
                "                'jobtitle' : 'Content Creator',\n" +
                "                'name' : 'Cesar Fajardo',\n" +
                "                'twitter' : 'fajardocesar',\n" +
                "                'workplace' : 'Platzi'\n" +
                "            },\n" +
                "            {\n" +
                "                'biography' : 'Soy Win. Greñudo, flaco y ojeroso. Hago fotografía los domingos. Head of production at @platzi',\n" +
                "                'category' : 12,\n" +
                "                'image' : 'https://pbs.twimg.com/profile_images/902939605221199872/eJypBkO__400x400.jpg',\n" +
                "                'jobtitle' : 'Head of Production',\n" +
                "                'name' : 'Ludwin Cuevas',\n" +
                "                'twitter' : 'winiberto',\n" +
                "                'workplace' : 'Platzi'\n" +
                "            },\n" +
                "            {\n" +
                "                'biography' : 'CEO y Fundador de Capptu el banco de fotografías que las conecta con las marcas y que además que fue reconocido por la revista Forbes México como promesa de negocios del 2018.',\n" +
                "                'category' : 10,\n" +
                "                'image' : 'https://pbs.twimg.com/profile_images/1042801434989879296/Dya62rEB_400x400.jpg',\n" +
                "                'jobtitle' : 'Founder & CEO',\n" +
                "                'name' : 'Manuel Villegas',\n" +
                "                'twitter' : 'manvillegasmx',\n" +
                "                'workplace' : 'Capptu'\n" +
                "            },\n" +
                "            {\n" +
                "                'biography' : 'Líder del equipo de Growth en Platzi y Google Doc Expert en Marketing, especialista en análisis de datos, presupuesto y proyecciones de Startups, lo que lo ha llevado a ser un gran conferencista a nivel mundial. Recuerden si estamos haciendo algo y no estamos aprendiendo de ello, no sirve de nada.',\n" +
                "                'category' : 9,\n" +
                "                'image' : 'https://pbs.twimg.com/profile_images/1128429578647736321/5ZwuI5_Q_400x400.jpg',\n" +
                "                'jobtitle' : 'Head of Growth',\n" +
                "                'name' : 'Juan Pablo Rojas',\n" +
                "                'twitter' : 'UnMalNick',\n" +
                "                'workplace' : 'Platzi'\n" +
                "            },\n" +
                "            {\n" +
                "                'biography' : 'Pablo Villanueva es Google Developer Expert, Co-fundador y Chief Technology en Metix Medical. Es un gran facilitador de equipos con metodologías ágiles y reconocido profesor de Platzi. SRE en Globant. Google Developer Expert y Google Cloud Authorized Trainer. Organizador en GDG Cloud MX.',\n" +
                "                'category' : 6,\n" +
                "                'image' : 'https://pbs.twimg.com/profile_images/1225834733549965312/JixgS3m__400x400.jpg',\n" +
                "                'jobtitle' : 'Co-founder & CTO',\n" +
                "                'name' : 'Pablo Villanueva',\n" +
                "                'twitter' : 'pablovillamx',\n" +
                "                'workplace' : 'Metix'\n" +
                "            },\n" +
                "            {\n" +
                "                'biography' : 'Co-fundadora de Fitco, donde estamos ayudando a Fitness Boutiques a crecer a través de la tecnología. Trabajando y apasionado por el crecimiento de SaaS a través de ventas, inbound marketing y asociaciones.',\n" +
                "                'category' : 11,\n" +
                "                'image' : 'https://media-exp2.licdn.com/dms/image/C4E03AQE3a2dbco8Niw/profile-displayphoto-shrink_800_800/0?e=1585180800&v=beta&t=Pb0KFPrtO-FR2zUlk_rPSPmZU_LAdpowWAt9s2LgzKA',\n" +
                "                'jobtitle' : 'CEO',\n" +
                "                'name' : 'Andrea Baba',\n" +
                "                'twitter' : 'butiqlive',\n" +
                "                'workplace' : 'FITco'\n" +
                "            },\n" +
                "            {\n" +
                "                'biography' : 'Claudia Sosa, diseñadora industrial y líder de CX Design de BBVA. Su fuerte, aplicar innovación en el diseño de productos y servicios. con tecnologías especializadas en mejorar la experiencia del cliente.',\n" +
                "                'category' : 4,\n" +
                "                'image' : 'https://pbs.twimg.com/profile_images/770787948719505408/KSvKmi9y_400x400.jpg',\n" +
                "                'jobtitle' : 'Head of CX Design',\n" +
                "                'name' : 'Claudia Sosa',\n" +
                "                'twitter' : 'claudiagizela',\n" +
                "                'workplace' : 'BBVA'\n" +
                "            },\n" +
                "            {\n" +
                "                'biography' : '• Never stop running • Innovation, my love • Let’s talk #OpenInnovation, #APIs & #OpenBanking • @archivomodamex',\n" +
                "                'category' : 14,\n" +
                "                'image' : 'https://pbs.twimg.com/profile_images/845058986034397185/T6ixCftF_400x400.jpg',\n" +
                "                'jobtitle' : 'Innovation Manager',\n" +
                "                'name' : 'Elina Corona',\n" +
                "                'twitter' : 'ninscorona',\n" +
                "                'workplace' : 'Open Banking'\n" +
                "            },\n" +
                "            {\n" +
                "                'biography' : 'Co-fundador y CEO de Iconic, empresario y estratega en servicios tecnológicos. Reconocido en el MIT Technology Review Innovator under 35 Awards como innovador social por su proyecto Votosocial.org',\n" +
                "                'category' : 8,\n" +
                "                'image' : 'https://pbs.twimg.com/profile_images/1102611265720107009/rUulO29A_400x400.png',\n" +
                "                'jobtitle' : 'CTO - Co-founder',\n" +
                "                'name' : 'Jorge Garcia',\n" +
                "                'twitter' : 'jagbolanos',\n" +
                "                'workplace' : 'Iconic'\n" +
                "            },\n" +
                "            {\n" +
                "                'biography' : 'Fue de los primeros webmasters en Guatemala. Su carrera inició en julio de 1997 cuando fundó Maestros del Web, plataforma que contenía cursos, noticias, tips y una gran comunidad de desarrolladores web con una misión: difundir el uso del internet y sus tecnologías. Durante 15 años, esta plataforma se convirtió en un referente a nivel Latinoamericano. Años más tarde, en 2004, cofundó Guate360, un blog dedicado a la comunidad guatemalteca donde se promociona al país a través de fotos, recetas de comida, tours virtuales, directorio de hoteles, restaurantes y atractivos turísticos. En 2009 vendió sus acciones. Las iniciativas de Christian continuaron y su amplio conocimiento en el campo le abrió muchas oportunidades para continuar emprendiendo. Fue así como en marzo de 2012 cofunda Platzi, una plaza dedicada a la educación en línea. Desde sus inicios, la plataforma ha roto esquemas de la educación en la web y se dedica a enseñar cursos sobre diseño, marketing y programación, impartidos por líderes de la industria tecnológica que promueven el desarrollo de habilidades tecnológicas profesionales. Actualmente posee más de 600 mil estudiantes en todo el mundo y tiene una tasa de finalización del 70%. En Platzi, Christian se preocupa por hablar con los estudiantes, desarrollar la estrategia de contenido, gestionar la logística, los recursos financieros y los recursos humanos de la empresa.',\n" +
                "                'category' : 2,\n" +
                "                'image' : 'https://pbs.twimg.com/profile_images/703539825853464577/jppQNmXD_400x400.jpg',\n" +
                "                'jobtitle' : 'Co-fundador',\n" +
                "                'name' : 'Christian Van Der Henst',\n" +
                "                'twitter' : 'cvander',\n" +
                "                'workplace' : 'Platzi'\n" +
                "            },\n" +
                "            {\n" +
                "                'biography' : 'Periodista. De #Michoacán. Madrileña adoptiva. Siempre una escala en #GDL. No como pizza con piña. Le voy al @ClubAmerica. Defeña.',\n" +
                "                'category' : 13,\n" +
                "                'image' : 'https://pbs.twimg.com/profile_images/1231252218562646019/X_NpdqKK_400x400.jpg',\n" +
                "                'jobtitle' : 'Periodista',\n" +
                "                'name' : 'Veronica Calderon',\n" +
                "                'twitter' : 'veronicalderon',\n" +
                "                'workplace' : ''\n" +
                "            },\n" +
                "            {\n" +
                "                'biography' : 'Colombiano, fue elegido uno de los 20 latinos más influyentes del año en la industria de la tecnología por CNET en Español, al lado de personalidades que trabajan en empresas como Tesla, Google, Apple, Microsoft, Samsung y GitHub. Cumplió 33 años hace poco, pero tenía solo 17 años cuando fundó Cristalab.com, cuya comunidad se convirtió en una referencia en diseño interactivo, desarrollo web y programación. Antes de ser el socio de Christian, era su competidor. Arrancaron esto con un streaming semanal, que hoy reconoces como Platzi Live cada semana. Todo cambió entre otras cosas con un viaje que hicieron juntos a Japón - la cultura japonesa es una pasión que comparten. Son parte de la red Endeavor y de los alumni de Y Combinator. Este importante programa de apoyo a emprendimientos los aceptó en su versión del 2015, donde fueron la primera empresa de la región cuya audiencia estaba en Latinoamérica. Freddy está a cargo de dirigir la empresa, de reclutamiento y también es de nuestro más reconocidos profesores. Además del curso de programación básica, también es uno de los instructores de nuestro taller de startups, exclusivo para los estudiantes con suscripción anual de Platzi. Su autor favorito es el escritor de ciencia ficción Robert A. Heinlein. Es aficionado al tiro deportivo, a la astronomía… y al lanzamiento de drones.',\n" +
                "                'category' : 1,\n" +
                "                'image' : 'https://pbs.twimg.com/profile_images/1062767896269590528/vOsDt9up_400x400.jpg',\n" +
                "                'jobtitle' : 'CEO',\n" +
                "                'name' : 'Freddy Vega',\n" +
                "                'twitter' : 'freddier',\n" +
                "                'workplace' : 'Platzi'\n" +
                "            },\n" +
                "            {\n" +
                "                'biography' : 'Cada cuadro tiene un proceso que debe hacerse antes de la acción de juego.',\n" +
                "                'category' : 17,\n" +
                "                'image' : 'https://pbs.twimg.com/profile_images/976117964591087617/61w43dr0_400x400.jpg',\n" +
                "                'jobtitle' : 'Production Manager',\n" +
                "                'name' : 'Erika Oregel',\n" +
                "                'twitter' : 'oregeler',\n" +
                "                'workplace' : 'Platzi'\n" +
                "            },\n" +
                "            {\n" +
                "                'biography' : 'Course Director del equipo de Education en Platzi. Blogguera y periodista del Universal en México, especialista en técnicas orales y escritas del periodismo con una amplia visión en el mundo digital.',\n" +
                "                'category' : 7,\n" +
                "                'image' : 'https://pbs.twimg.com/profile_images/674117824135081984/p5SJ33YJ_400x400.jpg',\n" +
                "                'jobtitle' : 'Course Director',\n" +
                "                'name' : 'Isis García',\n" +
                "                'twitter' : 'IsisConVelo',\n" +
                "                'workplace' : 'Platzi'\n" +
                "            },\n" +
                "            {\n" +
                "                'biography' : 'Director and cinematographer. Writer, Podcaster and teacher of audiovisual content.',\n" +
                "                'category' : 16,\n" +
                "                'image' : 'https://media-exp2.licdn.com/dms/image/C4E03AQF-6RBsJ6-iDA/profile-displayphoto-shrink_800_800/0?e=1585180800&v=beta&t=yLMYrEr0O19UdV30I2Ff2LgjMDDyoWH9qpDGSIXNgA8',\n" +
                "                'jobtitle' : 'Writer',\n" +
                "                'name' : 'Nicolay Coral',\n" +
                "                'twitter' : 'nicolaycoral',\n" +
                "                'workplace' : ''\n" +
                "            },\n" +
                "            {\n" +
                "                'biography' : 'Mario Valle es uno de los mexicanos más prominentes de Silicon Valley. Fue pionero de la industria de videojuegos en América Latina y por 11 años fue ejecutivo de la gigante Electronic Arts.\u2028¿Por qué, entonces, dejarlo todo para lanzarse a ser inversionista?\u2028Mario (donante y fan #terco de la primera hora) nos cuenta que estaba cómodo y contento en EA. Pero la oportunidad que vio de invertir en videojuegos de creadores independientes en Asia, Europa, América Latina y hasta África le pareció demasiado grande para dejarla pasar.\u2028Lanzó Altered Ventures, un fondo que invierte como si fuera una productora de Hollywood: Le mete dinero a los proyectos, los videojuegos, y no a las empresas. Por lo tanto, no les pide a los desarrolladores que le cedan un porcentaje de propiedad de sus compañías, lo que –dice– en regiones como América Latina lleva a abusos de parte de los inversionistas. Mario tiene 36 millones de dólares para invertir en nuevos títulos y parte de su trabajo para lanzar el fondo fue viajar por el mundo jugando videojuegos para conocer qué es lo que viene. Ya invirtió en un juego innovador hecho en Noruega (que se lanza el 21 de junio en Nintendo Switch) y pronto vienen más.',\n" +
                "                'category' : 3,\n" +
                "                'image' : 'https://pbs.twimg.com/profile_images/1177427481831194625/MGmAHgel_400x400.jpg',\n" +
                "                'jobtitle' : 'Angel Investor & Co-founder',\n" +
                "                'name' : 'Mario Valle',\n" +
                "                'twitter' : 'bilbeny',\n" +
                "                'workplace' : 'Altered Ventures'\n" +
                "            },\n" +
                "            {\n" +
                "                'biography' : 'Tuerto en país de ciegos | Nerd empedernido | Constructor de marcas | Estratega digital',\n" +
                "                'category' : 15,\n" +
                "                'image' : 'https://pbs.twimg.com/profile_images/1125995646585065474/oJkHqDhY_400x400.png',\n" +
                "                'jobtitle' : 'Director',\n" +
                "                'name' : 'Ruben Gomez',\n" +
                "                'twitter' : 'soyrubengomez',\n" +
                "                'workplace' : 'gom360'\n" +
                "            }\n" +
                "        ]")
        val jsonArr2 = JSONArray("[\n" +
                "            {\n" +
                "                \"datetime\" : 1564830000,\n" +
                "                \"description\" : \"Yo les voy a hablar el día de hoy de un tema que si soy exitoso, contrario a lo que algunos de ustedes me conocen saben que juego muchos videojuegos y que trabajo con ellos, toda mi vida llevo 21 años hablando en público a lo largo de la industria de la tecnología y alrededor por supuesto de la oportunidad tremenda que los videojuegos, la realidad virtual y la realidad aumentada ofrecen, sigo convencido en ello y sigo trabajando en eso. Pero estoy aquí con otro sombrero, el día de hoy si soy exitoso van a terminar con dos sentimientos, un poco de miedo y sobretodo el miedo que desemboca en la acción.\",\n" +
                "                \"speaker\" : \"Mario Valle\",\n" +
                "                \"tag\" : \"Negocios\",\n" +
                "                \"title\" : \"Ahorrar no te va a salvar del futuro\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"datetime\" : 1564862400,\n" +
                "                \"description\" : \"En esta charla Erika Oregel del equipo de Platzi nos invita a explorar nueva forma de adquirir gustos y pasiones, nos invita a procrastinar de forma consciente. \",\n" +
                "                \"speaker\" : \"Erika Oregel\",\n" +
                "                \"tag\" : \"Procastinación\",\n" +
                "                \"title\" : \"Procrastinar puede ser el alimento de tus futuras pasiones\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"datetime\" : 1564860000,\n" +
                "                \"description\" : \"Periodismo en 2019: Constar historias no debe ser aburrido.\",\n" +
                "                \"speaker\" : \"Veronica Calderón\",\n" +
                "                \"tag\" : \"Periodismo\",\n" +
                "                \"title\" : \"Periodismo en 2019: Constar historias no debe ser aburrido.\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"datetime\" : 1564861200,\n" +
                "                \"description\" : \"Tener una marca personal es fundamental para tu desarrollo profesional. Construir un portafolio de proyectos y fortalecer tu presencia online te ayudará a resaltar para ampliar tus oportunidades laborales, conseguir un mejor empleo o crear tu propio negocio.\",\n" +
                "                \"speaker\" : \"Rubén Gómez\",\n" +
                "                \"tag\" : \"Diseño\",\n" +
                "                \"title\" : \"¿Tienes una marca personal o solo redes sociales?\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"datetime\" : 1564837200,\n" +
                "                \"description\" : \"Hoy quiero hablarles de los dos tipos de personas que existen en el mundo, hay personas que consumen y hay personas que crean, todos somos de las primeras, todo el tiempo estamos consumiendo, consumimos tecnología, consumimos libros, películas, series, comida, el problemas es que no todo el mundo esta creando y cuando me refiero a crear me refiero a crear productos servicios, eventos, cosas que le aporten algo a la comunidad o al mundo, porque es un problema que no tanta gente este creando como la que esta consumiendo, porque le estamos quitando al mundo mas de lo que le dejamos, no estamos dejando este mundo mejor de como lo encontramos, eso genera consumismo y eso es un problema.\",\n" +
                "                \"speaker\" : \"Cesar Fajardo\",\n" +
                "                \"tag\" : \"Content\",\n" +
                "                \"title\" : \"Un 'gracias' vale más que un millón de views\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"datetime\" : 1564858800,\n" +
                "                \"description\" : \"En esta charla Andrea Baba, CEO de FITco, nos explica cómo llevar una vida saludable sin muchos sacrificios para complementar tu carrera profesional. \",\n" +
                "                \"speaker\" : \"Andrea Baba\",\n" +
                "                \"tag\" : \"Firness\",\n" +
                "                \"title\" : \"Una vida FIT te hace un mejor profesional\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"datetime\" : 1564826400,\n" +
                "                \"description\" : \"A lo largo de mi presentación les contaré algunas historias para que nunca paren de aprender. Cada semana gracias al equipo increíble de Platzi a mi me encanta contar las noticias porque entender nuestra industria es aprender a dominarla solo cuando entendemos como esta pasando y como las grandes empresas están creando podemos ser parte de ésta transformación entonces algo que me divierte a mi es leer es compartir y es analizar algunas de estas noticias, a veces no hago tan buen trabajo, a veces entiendo 2 o 3 cosas que están pasando con el mundo, pero cada vez más estoy haciendo un esfuerzo porque estas noticias sean más locales.   \",\n" +
                "                \"speaker\" : \"Christian Van Der Henst\",\n" +
                "                \"tag\" : \"Motivacional\",\n" +
                "                \"title\" : \"Diseñador, programador, creador y luego emprendedor\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"datetime\" : 1564861800,\n" +
                "                \"description\" : \"En esta charla Nicolay Coral nos explica cómo construimos sentimientos a través del cúmulo de emociones repetitivas  y cómo al lograr identificar qué y quién despiertan nuestras emociones podemos desaprender a ser felices. \",\n" +
                "                \"speaker\" : \"Nicolay Coral\",\n" +
                "                \"tag\" : \"Felicidad\",\n" +
                "                \"title\" : \"Desaprender a ser Feliz | Diferencia entre emociones y sentimientos\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"datetime\" : 1564840800,\n" +
                "                \"description\" : \"Les quiero comentar de cómo se pueden convertir en un MVP, en el MVP que el mundo necesita, haciéndose una pregunta, ¿Quiénes saben que es un MVP?, quiero comentarles como poder hacer el MVP de su equipo de desarrollo.\",\n" +
                "                \"speaker\" : \"Pablo Villanueva\",\n" +
                "                \"tag\" : \"Desarrollo\",\n" +
                "                \"title\" : \"Cómo convertirte en la persona más valiosa de una empresa\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"datetime\" : 1564860600,\n" +
                "                \"description\" : \"Redefiniendo la competencia en el mercado financiero: Open Banking\",\n" +
                "                \"speaker\" : \"Elina Corona\",\n" +
                "                \"tag\" : \"Bank\",\n" +
                "                \"title\" : \"Redefiniendo la competencia en el mercado financiero: Open Banking\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"datetime\" : 1564848000,\n" +
                "                \"description\" : \"Somos una empresa enfocada en el desarrollo de aplicaciones móviles del lado de la ingeniería y tuvimos por primera vez a una diseñadora en el equipo, al principio la veíamos como un adherido al equipo, luego empezamos un proyecto y ahora vengo a comentarles lo que pasó con la comunicación con personas que son de otras áreas.\",\n" +
                "                \"speaker\" : \"Jorge García\",\n" +
                "                \"tag\" : \"Git\",\n" +
                "                \"title\" : \"Git, la base de la colaboración mucho más allá del código\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"datetime\" : 1564855200,\n" +
                "                \"description\" : \"Tuve una idea de negocio de vender las imágenes de un teléfono, más de 1 personas me dijo que es la idea más estúpida que haya escuchado, pero yo estaba viendo el futuro que los teléfonos estaban marcando tendencia y que quizá hace años el que uno pueda vender sus fotos a una empresa grande haya sido una locura, pero hoy en día puedes convertir la cámara de tu teléfono un negocio.\",\n" +
                "                \"speaker\" : \"Manuel Villegas\",\n" +
                "                \"tag\" : \"Emprendimiento\",\n" +
                "                \"title\" : \"La cámara de tu teléfono puede ser un negocio\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"datetime\" : 1564859400,\n" +
                "                \"description\" : \"En esta charla Ludwin Cuevas nos enseña cómo gestiona a un equipo de 20 personas en el quipo de producción audiovisual de Platzi y nos comparte 5 tips para lograrlo   Los tips que @winiberto nos comparte son:  - Contrata a personas mejores que tú. - Tener claras las expectativas - Reuniones recurrentes - Crear conexiones humanas - Pedir retroalimentación\",\n" +
                "                \"speaker\" : \"Ludwin Cuevas\",\n" +
                "                \"tag\" : \"Creative\",\n" +
                "                \"title\" : \"5 consejos para liderar equipos grandes\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"datetime\" : 1564844400,\n" +
                "                \"description\" : \"Uno de los ejercicios hechos por la mayoría de los speakers profesionales, para mejorar como dan un mensaje, la premisa es fácil, no poner atención en lo que están diciendo, sino en cómo lo están diciendo y vengo a compartirles algunas técnicas que aprendí.\",\n" +
                "                \"speaker\" : \"Isis García\",\n" +
                "                \"tag\" : \"Voz\",\n" +
                "                \"title\" : \"Cómo comunicarte en un mundo saturado de información\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"datetime\" : 1564833600,\n" +
                "                \"description\" : \"El título de la charla se llama Workshops de alto impacto para ideas de alto impacto, yo pienso en mi experiencia personal en el banco, mas bien son Workshops de alto impacto en la vida, yo entré a BBVA hace 3 años, soy diseñadora industrial de la UNAM, empecé como todos con un trabajo pequeño, muy duro encontrar mi primer trabajo y me pagaban una miseria y ustedes debieron vivir algo así, entonces BBVA me dio la oportunidad de entrar a trabajar a un lugar decente y vengo a compartirles acerca de mi experiencia.\",\n" +
                "                \"speaker\" : \"Claudia Sosa\",\n" +
                "                \"tag\" : \"Negocios\",\n" +
                "                \"title\" : \"Crear workshops para comprender, idear y decidir\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"datetime\" : 1564851600,\n" +
                "                \"description\" : \"Hoy les voy a hablar de 5 formas de mentir con estadística.  Vamos a hablar de distintos métodos estadísticos que se utilizan y para que se utilizan en el diario vivir y tecnología.\",\n" +
                "                \"speaker\" : \"Juan Pablo Rojas\",\n" +
                "                \"tag\" : \"Estadística\",\n" +
                "                \"title\" : \"5 formas de mentir (o ser engañado) con datos\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"datetime\" : 1564822800,\n" +
                "                \"description\" : \"Hoy vamos a hablar de como desarrollar tu carrera profesional pero en tecnología, porque hay otras carreras que tienen menos crecimiento que la carrera de tecnología, cuando ustedes trabajan en tecnología ustedes entran en una carrera que tiene desempleo negativo, una carrera que tiene la demanda más fuerte del mercado, si nosotros vemos los sueldos en los últimos años en tecnología, en el 2013 el desarrollador de software promedio en Latinoamérica ganaba alrededor de 1100 dólares, hoy en el 2018 el desarrollador de software promedio gana 1650 dólares, pero el top 25% de desarrolladores de software ganan 2500 dólares en promedio, normalmente el rango el gradiente de sueldos de los estudiantes de Platzi que estudian un año o más es de 1000 a 3500 dólares al mes en Latinoamérica.\",\n" +
                "                \"speaker\" : \"Freddy Vega\",\n" +
                "                \"tag\" : \"Motivacional\",\n" +
                "                \"title\" : \"Cómo desarrollar tu carrera profesional en tecnología\"\n" +
                "            }\n" +
                "        ]")
```