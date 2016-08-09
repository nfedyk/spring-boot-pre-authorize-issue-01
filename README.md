# spring-boot-pre-authorize-issue-01

https://gitter.im/spring-projects/spring-security?at=57a9d71346610f17394b8ed5

In `Application.java`

Uncomment the block below for have `@PreAuthorize` annotations defined in `TestRecordRepository`
**NOT be evaluated** (unexpected)

Comment out the block, and `@PreAuthorize` annotations in `TestRecordRepository` will work as expected

See: `MyPermissionEvaluator.java` which will be executed as evidence of the
`@PreAuthorize` annotations working or not (prints to STDOUT)

```
@Autowired
private TestRecordRepository testRecordRepository;
```


```
./gradlew bootRun
```

To invoke, hit `http://localhost:8080/testrecords/search/findByFirstname?fn=1`
