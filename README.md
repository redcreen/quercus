Quercus是什么

    Quercus是一个开源的Php5引擎，完全由Java实现.
为什么要单独维护：

    Quercus在使用过程中发现了不少bug，为了能够快速响应，单独拉一个分支维护
    如果是quercus本身的bug，会提交到quercus官网。也会定期将quercus官网的修改同步回来，尽量保持最新
问题提交：

    https://github.com/redcreen/quercus/issues
Querces编译：

    1. cd resin-jcache &&  mvn install  （resin-jcache与其他javax-cache 接口不同，需要用这个）
    2. cd resin-kernel &&  mvn install （quercus依赖resin-kernel）
    3. cd resin-gae && mvn install (quercus中包含了GAE的支持，因此对gae api有依赖）
    4. cd quercus && mvn package
