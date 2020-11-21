# Teams

This document shall explain the team structure defined by the professor that guides this group project.

> "Each SCRUM Team participates in the Case Study & Root Cause Analysis. All are supervised by the _Project Scrum Team_. The SCRUM Teams, 1 through 4 have been assigned to specific subsystems: _Display 1, Display 2 , Middleware 1, Middleware2, & Database 1, Database 2_. Teams have been split into 2 parts due to the Class Project’s complexity. These Subsystems conform to the _classical 3-layer closed architecture_. That is, Display knows only about Middleware, and Middleware only knows about Database. Only Display can issue requests to Middleware in response to requests from an External Actor. Only Middleware can issue requests to Database. Database can only respond to requests from Middleware."

\- 2020_Fall_CSI3370 Class Project SCRUM Team Assignments, Roles & Responsibilities_v1.0_201018

## Product Owner

The professor is the product owner. All requirements come from the professor.

## Admin (Project SCRUM Team)

> "The Project SCRUM Team is responsible for managing the Project. The Project SCRUM Team will coordinate the efforts of all the other SCRUM Teams. The Project SCRUM Master will ensure that all SCRUM Teams meet their objectives so that the Class Project finishes on time (Final Project Review). The Project Assistant SCRUM Master will ensure that all required work products meet the requirements as provided by the Instructor & are completed in time to support the Class Project overall objectives."

\- 2020_Fall_CSI3370 Class Project SCRUM Team Assignments, Roles & Responsibilities_v1.0_201018

**Project SCRUM Master:** Brendan Fraser ([@brendanfraser597](https://github.com/brendanfraser597/))

**Project SCRUM Assistant Master:** Tessa Peruzzi ([@TessaPeruzzi](https://github.com/TessaPeruzzi/))

**Project SCRUM Integration Master:** Andrew Dimmer ([@andrewdimmer](https://github.com/andrewdimmer/))

## Display

> The SCRUM Display Team is responsible for all work products & efforts involved in developing the Display Interface to the _SecureLocTracker System_ for all human and machine External Actors. Display shall not perform persistent calculations or storage. Display shall pass all requests to Middleware and take returns from requests to Middleware.

\- 2020_Fall_CSI3370 Class Project SCRUM Team Assignments, Roles & Responsibilities_v1.0_201018

### Display_01

In particular, the Display_01 team is in charge of the GPS Receiver and the ~~GIS RFID Transponder Interface~~ (cut due to time constraints by the professor).

**Team SCRUM Master:** Eric Chan ([@EC01EC](https://github.com/EC01EC/))

**Team SCRUM Assistant Master:** Steve Catherman ([@stevecatherman](https://github.com/stevecatherman/))

**Team SCRUM Integrator:** Cody Asher ([@casher-ou](https://github.com/casher-ou/))

**Team Members:**

- John Akroush ([@John-A11](https://github.com/John-A11/))
- Evan Lilley ([@elilley15](https://github.com/elilley15/))
- David Lindner ([@DLidz](https://github.com/DLidz/))
- Andrew Poynter ([@atpoynter](https://github.com/atpoynter/))
- Reed Sikorski ([@reedsikorskiOU](https://github.com/reedsikorskiOU/))

### Display_02

In particular, the Display_02 team is in charge of the COMM 2-Way Link Interface.

**Team SCRUM Master:** Jessica Cortes ([@jcortes18](https://github.com/jcortes18/))

**Team SCRUM Assistant Master:** Sydney Hill ([@sydneyhill3901](https://github.com/sydneyhill3901/))

**Team SCRUM Integrator:** Jonathan Chan ([@Volter43](https://github.com/Volter43/))

**Team Members:**

- David Baker ([@Dbaker19972](https://github.com/Dbaker19972/))
- Paul Hardwoodward ([@phardwoodward](https://github.com/phardwoodward/))
- Anthony Hartman ([@Ahartman3](https://github.com/Ahartman3/))
- Tin Liu ([@MetalMan1992](https://github.com/MetalMan1992/))
- Jacob McCloud ([@jmccloud827](https://github.com/jmccloud827/))
- Yousif Sallan ([@yousifsallan](https://github.com/yousifsallan/))

## Middleware

> "The SCRUM Middleware1 & Middleware2 Teams (_'Middleware'_) are responsible for all work products & efforts involved in developing the logic manager for the System. Middleware shall implement the 'business rules' that govern the functional & nonfunctional behavior of the System. Middleware shall handle all requests from Display and make any store or retrieve requests to Database."

\- 2020_Fall_CSI3370 Class Project SCRUM Team Assignments, Roles & Responsibilities_v1.0_201018

### Middleware_01

In particular, the Middleware_01 team is in charge of the GIS Processor.

**Team SCRUM Master:** Brenda Morquecho ([@brendam19](https://github.com/brendam19/))

**Team SCRUM Assistant Master:** Julia Wang ([@juliawang2014](https://github.com/juliawang2014/))

**Team SCRUM Integrator:** Martin Hughes ([@martinhughes0722](https://github.com/martinhughes0722/))

**Team Members:**

- Stan Barczak ([@BarczakS](https://github.com/BarczakS/))
- Y Duong ([@duongy18418](https://github.com/duongy18418/))
- Syed Hayat ([@shayat97](https://github.com/shayat97/))
- Talha Memon ([@slackjaw1431](https://github.com/slackjaw1431/))
- Pujan Shah ([@Bimmerboi-248](https://github.com/Bimmerboi-248/))
- Steven Naoum ([@san4497](https://github.com/san4497/))

### Middleware_02

In particular, the Middleware_02 team is in charge of the COMM Link Manager.

**Team SCRUM Master:** Kenzie King ([@mckenzieking](https://github.com/mckenzieking/))

**Team SCRUM Assistant Master:** Kal Willard ([@kwillard34](https://github.com/kwillard34/))

**Team SCRUM Integrator:** Rio Capollari ([@rcapollari](https://github.com/rcapollari/))

**Team Members:**

- Rayvin Benno ([@tomtomtomcat](https://github.com/tomtomtomcat/))
- Nik Bergamin ([@nbergamin123](https://github.com/nbergamin123/))
- Ali El-Nazly ([@GitLee32](https://github.com/GitLee32/))
- Tyler Rode ([@Trode21](https://github.com/Trode21/))
- Nou Moua ([@NMoua-Edu](https://github.com/NMoua-Edu/))
- Caleb White ([@windwakes](https://github.com/windwakes/))

## Database

> "The SCRUM Database Team is responsible for all work products & efforts involved in developing the data storage capability for the System. Database shall not initiate any requests but rather, take all requests from, & respond to, Middleware."

\- 2020_Fall_CSI3370 Class Project SCRUM Team Assignments, Roles & Responsibilities_v1.0_201018

In particular, the Database team is in charge of the ~~GIS Volatile Info~~ (cut due to time constraints by the professor), GIS Persistent Info, ~~COMM Volatile Info~~ (cut due to time constraints by the professor), and COMM Persistent Info.

**Team SCRUM Master:** Cam'Ron Grant ([@camrongrant1](https://github.com/camrongrant1/))

**Team SCRUM Assistant Master:** Kyle Poterek ([@kylepoterek](https://github.com/kylepoterek/))

**Team SCRUM Integrator:** Mathew Yaldo ([@MathewYaldo](https://github.com/MathewYaldo/))

**Team Members:**

- Robertson Brinker ([@robertsonbrinker](https://github.com/robertsonbrinker/))
- Jake Gleason ([@Jake-wq](https://github.com/Jake-wq/))
- Ian Klaus ([@Ian-Klaus](https://github.com/Ian-Klaus/))
- Kemal Koymen ([@letthatbe](https://github.com/letthatbe/))
- Endrit Zenuni ([@Endritz](https://github.com/Endritz/))
