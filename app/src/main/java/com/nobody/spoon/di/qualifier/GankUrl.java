package com.nobody.spoon.di.qualifier;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 基于同一个维度条件下，若一个类的实例有多种方法可以创建出来，那注入器（Component）应该选择哪种方法来创建该类的实例呢?
 *
 * Qualifier（限定符）就是解决依赖注入迷失问题的
 * 用要使用的创建类实例方法的标识对目标类相应的实例属性进行标注
 *
 */

@Qualifier
@Documented
@Retention(RUNTIME)
public @interface GankUrl {

}
