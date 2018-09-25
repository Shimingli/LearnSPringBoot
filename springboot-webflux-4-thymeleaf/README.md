#### 20180917
* Thymeleaf
* Thymeleaf是Web和独立环境的现代服务器端Java模板引擎，能够处理HTML，XML，JavaScript，CSS甚至纯文本。
  Thymeleaf的主要目标是提供一种优雅和高度可维护的创建模板的方式。为了实现这一点，它建立在自然模板的概念上，将其逻辑注入到模板文件中，不会影响模板被用作设计原型。这改善了设计的沟通，弥补了设计和开发团队之间的差距。
* `<p>Today is: <span th:text="${today}">13 february 2011</span>.</p>
`假设today的值为2015年8月14日，那么渲染结果为：<p>Today is: 2015年8月14日.</p>。可见Thymeleaf的基本变量和JSP一样，都使用${.}表示获取变量的值。  

* URL在Web应用模板中占据着十分重要的地位，需要特别注意的是Thymeleaf对于URL的处理是通过语法@{…}来处理的。Thymeleaf支持绝对路径URL `<a th:href="@{http://www.thymeleaf.org}">Thymeleaf</a>`

* 很多时候可能我们只需要对一大段文字中的某一处地方进行替换 `<span th:text="'Welcome to our application, ' + ${user.name} + '!'">`

* for循环:使用 th:each 标签 

* Thymeleaf同样支持多路选择Switch结构：

* https://blog.csdn.net/qq_32923745/article/details/78257686