��ͷ��һЩ��Ϣ

|
---|---|---|---

biased_lock�������Ƿ�����ƫ������ǣ�ֻռ1��������λ��Ϊ1ʱ��ʾ��������ƫ������Ϊ0ʱ��ʾ����û��ƫ������lock��biased_lock��ͬ��ʾ������ʲô��״̬��

age��4λ��Java�������䡣��GC�У����������Survivor������һ�Σ���������1��������ﵽ�趨����ֵʱ������������������Ĭ������£�����GC��������ֵΪ15������GC��������ֵΪ6������ageֻ��4λ���������ֵΪ15�������-XX:MaxTenuringThresholdѡ�����ֵΪ15��ԭ��

identity_hashcode��31λ�Ķ����ʶhashCode�������ӳټ��ؼ��������÷���System.identityHashCode()���㣬���Ὣ���д���ö���ͷ�С������������ƫ��������������������MarkWord���ֽ�û���㹻�Ŀռ䱣��hashCode����˸�ֵ���ƶ����ܳ�Monitor�С�

thread������ƫ�������߳�ID��

epoch��ƫ������ʱ�����

ptr_to_lock_record����������״̬�£�ָ��ջ������¼��ָ�롣

ptr_to_heavyweight_monitor����������״̬�£�ָ����������Monitor��ָ�롣

��ֻ�����������������������ܽ���
ƫ���ᣬ�������ֱ����������⣬ֻ��һ���߳̽����ٽ���������߳̽�������ٽ��������߳�ͬʱ�����ٽ�������

https://www.zhihu.com/question/39009953?sort=created �ڶ�������