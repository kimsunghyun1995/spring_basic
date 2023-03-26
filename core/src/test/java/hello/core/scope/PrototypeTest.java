package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PrototypeTest {

    @Test
    void prototypeBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ProtoType.class);
        System.out.println("find protoType1");
        ProtoType protoType1 = ac.getBean(ProtoType.class);
        System.out.println("find protoType2");
        ProtoType protoType2 = ac.getBean(ProtoType.class);
        System.out.println("protoType1 = " + protoType1);
        System.out.println("protoType2 = " + protoType2);
        assertThat(protoType1).isNotSameAs(protoType2);

        ac.close();
    }

    @Scope("prototype")
    static class ProtoType {
        @PostConstruct
        public void init() {
            System.out.println("protoType.init");
        }

        @PreDestroy
        public void close() {
            System.out.println("protoType.destory");
        }
    }

}
