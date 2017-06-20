<%--
  Created by IntelliJ IDEA.
  User: fuzhongyu
  Date: 2017/6/15
  Time: 上午10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
String path=${pageContext.request.contextPath}
%>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="statics/jquery/jquery-1.9.0.min.js"></script>
    <script type="text/javascript" src="statics/textEdit/kindeditor-all-min.js"></script>
    <script type="text/javascript" src="statics/textEdit/lang/zh-CN.js"></script>

    <script type="text/javascript"   src="statics/uploadify/jquery.uploadify.min.js"></script>
    <link rel="stylesheet" type="text/css" href="statics/uploadify/uploadify.css">

    <script>
        KindEditor.options.filterMode = false;

        KindEditor.ready(function(K) {
            window.editor = K.create('#editor');
        });



        $(function() {

            $('#photoname').uploadify({
                'swf'               : "statics/uploadify/uploadify.swf",
                'uploader'      :   "url",
                'cancelImg'     :   "statics/uploadify/uploadify-cancel.png",
                'debug'         :   true,
                'buttonText'    :   '选择照片',
                'method'            :   'post',
                'fileTypeDesc'  :   '图片文件',
                'fileTypeExts'  :   '*.gif;*.jpg;*.png;*.bmp',
                'multi'             :   false,

                'onUploadComplete': function(file){

                },

                /**
                 * 上传成功后触发事件
                 */
                'onUploadSuccess' : function(file, data, response) {

                },
            });
            //alert(PUBLIC);
        });
    </script>
</head>
<body>

<textarea id="editor" name="content" style="width:200px;height:300px;">测试</textarea>

<p>
    <label class="label">照片</label>
<table><tr><td>
    <div id="photo"><img src="statics/img/lei.png"/></div>
</td></tr></table>
<input class="text-input small-input" type="file" name="photo" id="photoname" />
</p>

<input type="hidden" name="photoname" id="photoname_hidden"/>

</body>
</html>
