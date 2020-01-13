# Multi
大型android项目基础架构，AndroidX、Koin、模块化、模块代码权限控制、单Activity多fragment


<img src="screenshots/liucheng.jpg" width = "50%"/> <img src="screenshots/shuoming.jpg" width = "50%"/>

## 说一说，扯一扯
###  1:为什么要有i18模块？
* 在多个项目开发的过程中，其实很多国际化的翻译是一样的，当你的i18越来越丰富，上传maven私服后，提供不同的项目引用，需要改的可能会越来越少
###  2:为什么要模块化？好处是什么？
* 最重要的是大型项目中，代码的权限控制，假设A,B,C同时开发一个项目，但是又不想给所有人整个项目的代码，可以这么处理，每一个模块建一个git仓库地址，给到对应同事所负责的模块git仓库，
通过聚合i18,base,router，(负责的模块)，单独运行APP开发，gradle.properties中进行配置是否是APP运行
###  3:那么这一套架子，我们该如何进行业务开发？
* 新模块，先可以copy user模块，改成自己对应模块名称，包括内部所有的类的名称改为自己模块名称，
setting.gradle 确保有模块名，gradle.properties中加入是否是APP的变量控制模块中build.gradle，
新建自己的fragment,在router模块中定义fragment的访问路径，i18中定义国际化资源，data目录下定义接口、业务bean,
Bus事件用于不同页面、不同模块通讯



