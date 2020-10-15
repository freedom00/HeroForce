# HeroForce

## Environment Setup

### Operating System

- Windows 10 X64

### IDE

- Intellij IDEA for Spring Boot
- WebStorm for Angular

## Frontend

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 10.1.6.

### Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.The detailed steps are as follows:

- cd HeroForce\frontend\src\assets\config
- open config.production.json
- edit the value of the key "create", this is the server url the default as follows:
  - "create": "http://localhost:8080/Person/create"
- cd HeroForce\frontend
- npm install
- ng serve --open

### Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

### Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `--prod` flag for a production build.

### Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

### Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).

### Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI README](https://github.com/angular/angular-cli/blob/master/README.md).

## Backend

This project was generated with [Spring Boot](https://github.com/spring-projects/spring-boot) version 2.3.4.RELEASE

### Development server

Run Spring Boot for a dev server. The detailed steps are as follows:

- cd HeroForce
- open backend folder with IDE Intellij IDEA
- open file backend\src\main\resources\application.properties

  - edit the value of the key "HeroForce.myEmailAccount", this is the email address used to send mail. the default as follows:

    HeroForce.myEmailAccount=xxxxxxx@xxx.com

  - edit the value of the key "HeroForce.myEmailPassword", this is the password of the email address used to send mail. the default as follows:

    HeroForce.myEmailPassword=xxxxxxxxxxxxxxx

  - edit the value of the key "HeroForce.myEmailSmtpHost", this is the host of the email address used to send mail. the default as follows:

    HeroForce.myEmailSmtpHost=smtp.xxxx.com

- run the project with IDE Intellij IDEA

### Further help

To get more help on the Spring Boot go check out the [Spring Boot README](https://github.com/spring-projects/spring-boot/blob/master/README.adoc).
