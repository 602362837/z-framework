使用说明（未标注某版本有效的代表全版本有效）：
------------------------------------------------------------------------------------------------------------------
@Exposed：该注解写在要拖过的类上
@Loading：该注解写再需要注入的属性上
------------------------------------------------------------------------------------------------------------------
Class:ZApplication-该类为核心入口，实例化后可直接通过该类提供的静态方法获取bean

------------------------------------------------------------------------------------------------------------------
web集成说明-1.0版本有效：
	再web.xml中加入
		<context-param>
			<param-name>z-framework-config</param-name>
			<param-value>config.yaml(配置文件路径-根据实际情况填写)</param-value>
		</context-param>
		<listener>
			<listener-class>cn.com.zyj.framework.temp.web.init.LoaderListener</listener-class>
		</listener>
------------------------------------------------------------------------------------------------------------------
配置文件示例说明-1.*版本只支持yaml文件：
#扫包路径（此项必选-value根据实际情况填写）
scanPackage : cn.com.zyj
#手工注册bean信息（可选）
beans : 
  TServiceImpl : test.service.impl.TServiceImpl
#用户自定义配置bean扫描器实现类路径（可选）
configBeanScanImpl:自定义配置bean扫描器实现
#用户自定义bean扫描器实现类路径（可选）
beanScanImpl:自定义bean扫描器实现
#用户自定义在注入扫描器（加载器）实现类路径（可选）
loadScanImpl:自定义加载器实现

------------------------------------------------------------------------------------------------------------------

依赖包说明：
jyaml-*.jar(建议使用jyaml-1.3.jar)
javax.servlet-api-*.jar(建议使用javax.servlet-api-3.1.0.jar)

maven引入依赖示例：
<dependency>
	<groupId>org.jyaml</groupId>
	<artifactId>jyaml</artifactId>
	<version>1.3</version>
</dependency>
<!-- 1.0依赖此模块，其他版本将不再依赖 -->
<dependency>
	<groupId>javax.servlet</groupId>
	<artifactId>javax.servlet-api</artifactId>
	<version>3.1.0</version>
</dependency>

--------------------------------------------------------------------------------
环境说明：
建议使用jdk1.8


