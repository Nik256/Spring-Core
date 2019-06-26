package org.shop;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.shop.annotation.CustomBean;
import org.shop.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * The ShopLauncher class.
 */
public class ShopLauncher {
    private static final Logger logger = LogManager.getLogger(ShopLauncher.class.getName());
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        logger.info(ctx.getBean(CustomBean.class));
        displayAllBeans(ctx);
    }

    private static void displayAllBeans(ApplicationContext applicationContext) {
        String[] allBeanNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : allBeanNames) {
            logger.info(beanName);
        }
    }
}
