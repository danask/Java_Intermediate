package ask.helloworld.intermediate;

//어노테이션은 클래스나 메소드위에 붙습니다. @(at)기호로 이름이 시작합니다.
//어노테이션을 클래스나 메타코드에 붙인 후, 클래스가 컴파일되거나 실행될 때 
//어노테이션의 유무나 어노테이션에 설정된 값을 통하여 클래스가 좀 더 다르게 실행되게 할 수 있습니다.
//이런 이유로 어노테이션을 일정의 설정파일처럼 설명하는 경우도 있습니다.

//어노테이션은 자바가 기본으로 제공해주는 것도 있고, 사용자가 직접 만들 수도 있습니다.
//사용자가 직접 작성하는 어노테이션을 Custom 어노테이션이라고 말합니다.

//커스텀 어노테이션을 이용하는 방법
//어노테이션을 정의한다.
//어노테이션을 클래스에서 사용한다. (타겟에 적용)
//어노테이션을 이용하여 실행.

import java.lang.annotation.*;



// Count100어노테이션을 JVM실행시에 감지할 수 있도록 하려면 @Retention(RetentionPolicy.RUNTIME)를 붙여줘야 합니다.

@Retention(RetentionPolicy.RUNTIME)

public @interface Count100
{

}
