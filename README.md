#springMVC 基础配置学习项目

-**springMVc 的配置基础配置项目**
- **项目创建**
- **基础配置**
- **高级配置**
- **测试**
-------------------
##项目构建

```
	
	<properties>
		<!-- Generic properties -->
		<java.version>1.8</java.version>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
		<!-- web -->
		<jsp.version>2.2</jsp.version>
		<jstl.version>1.2</jstl.version>
		<servlet.version>3.1.0</servlet.version>
		<!-- spring -->
		<spring.version>4.3.8.RELEASE</spring.version>
		<!-- Logging -->
		<logback.version>1.0.13</logback.version>
		<slf4j.version>1.7.5</slf4j.version>
		<log4j.version>1.2.16</log4j.version>
		<jackson.version>2.8.8</jackson.version>
		<fileupload.version>1.3.1</fileupload.version>
		<junit.test>4.12</junit.test>
	</properties>

	<dependencies>
		<!-- 编译期有效 -->
		<dependency>
			<groupId>javax</groupId>
			<artifactId>javaee-web-api</artifactId>
			<version>7.0</version>
			<scope>provided</scope>
		</dependency>
		<!-- SpringMvc -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-webmvc</artifactId>
			<version>${spring.version}</version>
		</dependency>
		<!-- Spring -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
			<version>${spring.version}</version>
		</dependency>
		<!-- spring and Transactions -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-tx</artifactId>
			<version>${spring.version}</version>
		</dependency>
		<!-- test  -->
		<dependency>
		 	<groupId>org.springframework</groupId>
		 	<artifactId>spring-test</artifactId>
		 	<version>${spring.version}</version>
		 	<scope>test</scope>
		 </dependency>
		<!-- other dependency -->

		<!-- jstl -->
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>jstl</artifactId>
			<version>${jstl.version}</version>
		</dependency>
		<!-- 编译期有效 -->
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>javax.servlet-api</artifactId>
			<version>${servlet.version}</version>
			<scope>provided</scope>
		</dependency>
		<!-- jsp -->
		<dependency>
			<groupId>javax.servlet.jsp</groupId>
			<artifactId>jsp-api</artifactId>
			<version>${jsp.version}</version>
		</dependency>
		<!-- slf4j and logback -->
		<dependency>
			<groupId>org.slf4j</groupId>
			<artifactId>slf4j-api</artifactId>
			<version>${slf4j.version}</version>
		</dependency>
		<dependency>
			<groupId>log4j</groupId>
			<artifactId>log4j</artifactId>
			<version>${log4j.version}</version>
		</dependency>
		<dependency>
			<groupId>org.slf4j</groupId>
			<artifactId>jcl-over-slf4j</artifactId>
			<version>${slf4j.version}</version>
		</dependency>
		<!-- classic +core -->
		<dependency>
			<groupId>ch.qos.logback</groupId>
			<artifactId>logback-classic</artifactId>
			<version>${logback.version}</version>
		</dependency>
		<!-- access -->
		<dependency>
			<groupId>ch.qos.logback</groupId>
			<artifactId>logback-access</artifactId>
			<version>${logback.version}</version>
		</dependency>
		<!-- json -->
		<dependency>
			<groupId>com.fasterxml.jackson.core</groupId>
			<artifactId>jackson-databind</artifactId>
			<version>${jackson.version}</version>
		</dependency>
		<!-- xml -->
		<dependency>
			<groupId>com.fasterxml.jackson.dataformat</groupId>
			<artifactId>jackson-dataformat-xml</artifactId>
			<version>${jackson.version}</version>
		</dependency>
		<!-- file upload -->
		 <dependency>
			<groupId>commons-fileupload</groupId>
			<artifactId>commons-fileupload</artifactId>
			<version>${fileupload.version}</version>
		</dependency>
		 <!-- 测试支持 -->
		 <dependency>
		 	<groupId>junit</groupId>
		 	<artifactId>junit</artifactId>
		 	<version>${junit.test}</version>
		 	<scope>test</scope>
		 </dependency>
	</dependencies>

	<build>
		<finalName>springmvc-basic-study</finalName>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>2.3.2</version>
				<configuration>
					<source>${java.version}</source>
					<target>${java.version}</target>
				</configuration>
			</plugin>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-war-plugin</artifactId>
				<version>2.3</version>
				<configuration>
					<!-- 不使用web.xml文件 -->
					<failOnMissingWebXml>false</failOnMissingWebXml>
				</configuration>
			</plugin>
			<!-- tomcat7插件 -->
		 	<!-- <plugin>
				<groupId>org.apache.tomcat.maven</groupId>
				<artifactId>tomcat7-maven-plugin</artifactId>
				<version>2.2</version>
				<configuration>
					<path>/${project.build.finalName}</path>
					<port>8080</port>
					<uriEncoding>UTF-8</uriEncoding>
					<finalName>${project.build.finalName}</finalName>
					名称必须与配置文件的id名称一致
					<server>tomcat7</server>
				</configuration>
				在打包周期运行tomcat7
				<executions>
					<execution>
						<phase>package</phase>
						<goals>
							<goal>run</goal>
						</goals>
					</execution>
				</executions> 
			</plugin>  -->
		</plugins>

	</build>
```
##项目基础配置