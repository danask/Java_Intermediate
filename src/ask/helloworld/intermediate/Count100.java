package ask.helloworld.intermediate;

//������̼��� Ŭ������ �޼ҵ����� �ٽ��ϴ�. @(at)��ȣ�� �̸��� �����մϴ�.
//������̼��� Ŭ������ ��Ÿ�ڵ忡 ���� ��, Ŭ������ �����ϵǰų� ����� �� 
//������̼��� ������ ������̼ǿ� ������ ���� ���Ͽ� Ŭ������ �� �� �ٸ��� ����ǰ� �� �� �ֽ��ϴ�.
//�̷� ������ ������̼��� ������ ��������ó�� �����ϴ� ��쵵 �ֽ��ϴ�.

//������̼��� �ڹٰ� �⺻���� �������ִ� �͵� �ְ�, ����ڰ� ���� ���� ���� �ֽ��ϴ�.
//����ڰ� ���� �ۼ��ϴ� ������̼��� Custom ������̼��̶�� ���մϴ�.

//Ŀ���� ������̼��� �̿��ϴ� ���
//������̼��� �����Ѵ�.
//������̼��� Ŭ�������� ����Ѵ�. (Ÿ�ٿ� ����)
//������̼��� �̿��Ͽ� ����.

import java.lang.annotation.*;



// Count100������̼��� JVM����ÿ� ������ �� �ֵ��� �Ϸ��� @Retention(RetentionPolicy.RUNTIME)�� �ٿ���� �մϴ�.

@Retention(RetentionPolicy.RUNTIME)

public @interface Count100
{

}