# spring-boot-repository-caching-issue-01

https://jira.spring.io/browse/DATAREST-876

```
./gradlew bootRun
```

To create record, run  `curl -X POST -H "Content-Type: application/json" -H "Cache-Control: no-cache" -d '{"firstname":"XXX", "lastname":"YYY"}' "http://localhost:8080/testrecords"`

```
onBeforeCreate UUID: null Firstname:XXX Lastname: YYY ID:my.test.TestRecord@32235396
Validator->Entity passed UUID: null Firstname:XXX Lastname: YYY ID:my.test.TestRecord@32235396
onAfterCreate UUID: 0b207a19-62b1-482b-a089-0547551e3424 Firstname:XXX Lastname: YYY ID:my.test.TestRecord@32235396
```

To update record, run `curl -X PATCH -H "Content-Type: application/json" -H "Cache-Control: no-cache" -d '{"firstname":"AAA"}' "http://localhost:8080/testrecords/generated_uuid"` where `generated_uuid` is the output of create.


I expect repository methods `findByFirstname` and `findByLastname` called from method annotated by `@Transactional(propagation=Propagation.REQUIRES_NEW)` to return actual DB instance, not the cached one.

This is the output pof `PATCH` request where cached instance is being returned for all find calls.

```
onBeforeSave UUID: 38fd344c-eaf7-49e5-badb-48fad14cd05e Firstname:AAA Lastname: YYY ID:my.test.TestRecord@32235396
Validator->Entity passed UUID: 38fd344c-eaf7-49e5-badb-48fad14cd05e Firstname:AAA Lastname: YYY ID:my.test.TestRecord@32235396
Validator->Fetched by uuid UUID: 38fd344c-eaf7-49e5-badb-48fad14cd05e Firstname:AAA Lastname: YYY ID:my.test.TestRecord@32235396
Validator->Fetched by firstname UUID: 38fd344c-eaf7-49e5-badb-48fad14cd05e Firstname:AAA Lastname: YYY ID:my.test.TestRecord@32235396
Validator->Fetched by lastname UUID: 38fd344c-eaf7-49e5-badb-48fad14cd05e Firstname:AAA Lastname: YYY ID:my.test.TestRecord@32235396
onAfterSave UUID: 38fd344c-eaf7-49e5-badb-48fad14cd05e Firstname:AAA Lastname: YYY ID:my.test.TestRecord@32235396
```
