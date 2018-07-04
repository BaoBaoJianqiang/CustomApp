# CustomApp
#
# ProductD演示的效果
#	什么都不加，基于Core，原始版本
#
# ProductA演示的效果
#	可以通过配置config的方式，让Scenario1Activity的按钮不显示，这需要在Core的Scenario1Activity中，使用else，来隐藏按钮
#
#<?xml version="1.0" encoding="UTF-8"?>
#<config>
#    <Page name="Scenario1Activity">
#        <Node key="show_button1" value="false" />
#    </Page>
#</config>
#
#	也可以只通过配置config的方式，让Scenario2Activity的按钮不显示，这需要在ProductA中提供一个新的activity_scenarios2布局文件，把这个按钮直接删除掉就好了。
#<Page name="Scenario2Activity">
#	<Node key="show_button" value="false" />
#</Page>
#
#	Node配置，不配置默认是true
#
#	查找Config，基于findConfig
#
#
#ProductB演示的效果
#	Scenario2Activity2，继承自Activity,
#
#	Scenario2Activity_new，继承自Scenario2Activity，代码复用
#
#	查找Map，基于findMap
#		map2是临时的，可以切换到map。验证另一个字符串是否work
#
#ProductC演示的效果
#	我试图加一个同名的Scenario2Activity，AS会提示类重复了，虽然也能编译，但是新的类会被ignore
#
#