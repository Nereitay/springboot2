package es.kiwi.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * 继承FactoryBean接口造出来的对象不是自身，而是泛型定义的类型
 */
public class DogFactoryBean implements FactoryBean<Dog> {
    @Override
    public Dog getObject() throws Exception {
        Dog dog = new Dog();
        //中间可以进行一系列的初始化工作
        return dog;
    }

    @Override
    public Class<?> getObjectType() {
        return Dog.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
