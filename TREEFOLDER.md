src/
 └── main/
     ├── java/
     │    └── com/
     │         └── otavio/
     │              └── passwordvalidator/
     │                   ├── api/
     │                   │    └── controller/
     │                   │         └── PasswordController.java
     │                   │
     │                   ├── application/
     │                   │    └── service/
     │                   │         └── PasswordService.java
     │                   │
     │                   ├── domain/
     │                   │    ├── model/
     │                   │    │     └── Password.java
     │                   │    ├── validator/
     │                   │    │     ├── PasswordValidator.java
     │                   │    │     ├── rules/
     │                   │    │     │     ├── DigitRule.java
     │                   │    │     │     ├── UppercaseRule.java
     │                   │    │     │     ├── LowercaseRule.java
     │                   │    │     │     ├── SpecialCharRule.java
     │                   │    │     │     └── NoRepeatRule.java
     │                   │    │     └── ValidationRule.java (interface)
     │                   │
     │                   ├── infrastructure/
     │                   │    ├── config/
     │                   │    │     └── SwaggerConfig.java
     │                   │    ├── logging/
     │                   │    └── actuator/
     │                   │
     │                   └── PasswordValidatorApplication.java
     │
     └── resources/
          ├── application.yml
          └── logback-spring.xml
          
 └── test/
     ├── java/
     │    └── com/
     │         └── otavio/
     │              └── passwordvalidator/
     │                   ├── api/
     │                   │    └── PasswordControllerTest.java
     │                   ├── application/
     │                   │    └── PasswordServiceTest.java
     │                   └── domain/
     │                        └── validator/
     │                             ├── DigitRuleTest.java
     │                             ├── UppercaseRuleTest.java
     │                             ├── LowercaseRuleTest.java
     │                             ├── SpecialCharRuleTest.java
     │                             └── NoRepeatRuleTest.java
     │
     └── resources/
          └── application-test.yml