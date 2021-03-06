##  Restful Demo  


* 要理解什么是REST，我们需要理解下面几个概念:
* 资源（Resources） REST是"表现层状态转化"，其实它省略了主语。"表现层"其实指的是"资源"的"表现层"。
* 那么什么是资源呢？就是我们平常上网访问的一张图片、一个文档、一个视频等。这些资源我们通过URI来定位，也就是一个URI表示一个资源。
* 表现层（Representation）
* 资源是做一个具体的实体信息，他可以有多种的展现方式。而把实体展现出来就是表现层，例如一个txt文本信息，他可以输出成html、json、xml等格式，一个图片他可以jpg、png等方式展现，这个就是表现层的意思。
* URI确定一个资源，但是如何确定它的具体表现形式呢？应该在HTTP请求的头信息中用Accept和Content-Type字段指定，这两个字段才是对"表现层"的描述。
* todo  注意看图片 RESTful表现层
* 状态转化（State Transfer）
* 访问一个网站，就代表了客户端和服务器的一个互动过程。在这个过程中，肯定涉及到数据和状态的变化。而HTTP协议是无状态的，那么这些状态肯定保存在服务器端，所以如果客户端想要通知服务器端改变数据和状态的变化，肯定要通过某种方式来通知它。

* RESTful 架构  1、每一个URL都代表了一种资源 2、客户端和服务器之间的通讯，传递这种资源的某种表现层-  3、客户端通过四个HTTP动词，对服务端资源进行操作，实现表现层状态的转化  


* Web应用要满足REST最重要的原则是:客户端和服务器之间的交互在请求之间是无状态的,即从客户端到服务器的每个请求都必须包含理解请求所必需的信息。如果服务器在请求之间的任何时间点重启，客户端不会得到通知。此外此请求可以由任何可用服务器回答，这十分适合云计算之类的环境。因为是无状态的，所以客户端可以缓存数据以改进性能。

*  另一个重要的REST原则是系统分层，这表示组件无法了解除了与它直接交互的层次以外的组件。通过将系统知识限制在单个层，可以限制整个系统的复杂性，从而促进了底层的独立性。
  
  	* 当REST架构的约束条件作为一个整体应用时，将生成一个可以扩展到大量客户端的应用程序。它还降低了客户端和服务器之间的交互延迟。统一界面简化了整个系统架构，改进了子系统之间交互的可见性。REST简化了客户端和服务器的实现，而且对于使用REST开发的应用程序更加容易扩展。
 
 [image](RESTful表现层.png) 	
 *   上图展示了我们目前实现REST的三个level，我们在应用开发的时候也不一定全部按照RESTful的规则全部实现他的方式，因为有些时候完全按照RESTful的方式未必是可行的，RESTful服务充分利用每一个HTTP方法，包括DELETE和PUT。可有时，HTTP客户端只能发出GET和POST请求：
   
  *  todo AJAX = Asynchronous JavaScript and XML（异步的 JavaScript 和 XML）。  AJAX 不是新的编程语言，而是一种使用现有标准的新方法。  AJAX 最大的优点是在不重新加载整个页面的情况下，可以与服务器交换数据并更新部分网页内容。 AJAX 不需要任何浏览器插件，但需要用户允许JavaScript在浏览器上执行
   	* HTML标准只能通过链接和表单支持GET和POST。在没有Ajax支持的网页浏览器中不能发出PUT或DELETE命令
	* 有些防火墙会挡住HTTP PUT和DELETE请求，要绕过这个限制，客户端需要把实际的PUT和DELETE请求通过 POST 请求穿透过来。RESTful 服务则要负责在收到的 POST 请求中找到原始的 HTTP 方法并还原。
   	
   * 我们现在可以通过POST里面增加隐藏字段_method这种方式可以来模拟PUT、DELETE等方式，但是服务器端需要做转换。我现在的项目里面就按照这种方式来做的REST接口 	