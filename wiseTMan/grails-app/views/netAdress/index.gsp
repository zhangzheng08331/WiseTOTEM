<%--
  Created by IntelliJ IDEA.
  User: pc-1
  Date: 2016/5/28
  Time: 14:49
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>zz网址导航</title>
    <meta name="layout" content="main"/>
    <meta charset="gbk"/>
    <meta name="baidu-site-verification" content="MfXZNl5oj2"/>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta name="generator" content="editplus"/>
    <meta name="author" content="zz"/>
    <meta name="keywords"
          content="软件,下载,绿色,软件下载,驱动下载,工具下载,免费软件下载,破解,破解论坛,破解软件，共享软件下载,最新免费资源,免费网站,免费网络,在线免费,free,答案，课后答案。"/>
    <meta name="description" content="优质的，良好的，免费资源下载站"/>
    <style type="text/css">
        .content {
            margin-top: 27px;
            font-size: 14px;
        }
        .content-top {
            border-top: 2px solid #e9e9e9;
        }

        .page-width {
            margin-right: auto;
            margin-left: auto;
            width: 1000px;
        }
        .ovh {
            overflow: hidden;
        }
        .sites {
            width: 80%;
            padding: 11px 0 9px 30px;
        }
        .mod {
            border: 1px solid #cecece;
        }
        .mt10 {
            margin-top: 10px;
        }
        ul{
            display: block;
            padding: 0;
            list-style: none;
            -webkit-margin-after: 1em;
            -webkit-margin-start: 0px;
            -webkit-margin-end: 0px;
            -webkit-padding-start: 40px;
        }
        .clearfix {
            zoom: 1;
        }
        .fl {
            float: left;
        }
        .sites .site {
            width: 110px;
            line-height: 32px;
        }
        .clr-black {
            color: #1c1c1c;
        }
        .clr-black:hover {
            color: #0000d0;
        }
        .clearfix:after {
            clear: both;
            content: ".";
            display: block;
            height: 0;
            line-height: 0;
            visibility: hidden;
        }

    </style>
</head>

<body>
    <div class="content">
        <div class="clearfix content-top page-width">
            <g:each var="webs" in="${websites}">
                <div id="cate_${webs.key.orderid}" class="sites mod mt10">
                    <ul class="clearfix">
                        <g:each var="web" in="${webs.value}">
                            <li class="fl site" title="${web.websiteAbstract}">
                                <a target="_blank" href="${web.websiteURL}" class="clr-black">${web.websiteName}</a>
                            </li>
                        </g:each>
                    </ul>
                </div>
            </g:each>
        </div>
    </div>

</body>
</html>