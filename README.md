# Robolectric memory leak when calling multiple app startups

1. Run `./gradlew test` (or run unit tests in the IDE)
2. Test pass ✅
3. But: notice in stdout that the memory is always increasing, and resources are not released:

```plain
Used heap Size = 46.65666961669922 MB
Used heap Size = 81.19964599609375 MB
Used heap Size = 108.21515655517578 MB
Called loadFromPath(/system/framework/framework-res.apk, true); mode=binary sdk=28
Used heap Size = 156.23092651367188 MB
Called loadFromPath(/system/framework/framework-res.apk, true); mode=binary sdk=29
Used heap Size = 207.0097427368164 MB
Used heap Size = 262.7805938720703 MB
Used heap Size = 322.60746002197266 MB
Used heap Size = 382.8641891479492 MB
Used heap Size = 447.7919006347656 MB
```

See picture:
![Shows app start test results with growing memory](appstart_tests.png)
