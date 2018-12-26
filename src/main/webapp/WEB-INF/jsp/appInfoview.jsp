<%--
  Created by IntelliJ IDEA.
  User: 你爷
  Date: 2018/12/25
  Time: 8:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<%@ include file="common/header.jsp"%>
<div class="clearfix"></div>
<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="x_panel">
            <div class="x_title">
                <h2>查看APP基础信息 <i class="fa fa-user"></i><small>${devUserSession.devName}</small></h2>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">
                <form class="form-horizontal form-label-left" action="modify" method="post" enctype="multipart/form-data">
                    <input type="hidden" name="id" id="id" value="${appInfo.id}">
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">软件名称 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input id="softwareName" class="form-control col-md-7 col-xs-12"
                                   data-validate-length-range="20" data-validate-words="1"
                                   name="softwareName" value="${appInfo.softwareName}" required="required"
                                   placeholder="请输入软件名称" type="text" readonly="readonly">
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">APK名称 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input id="APKName" type="text" class="form-control col-md-7 col-xs-12"
                                   name="APKName" value="${appInfo.APKName}" readonly="readonly">
                        </div>
                    </div>

                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">支持ROM <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input id="supportROM" class="form-control col-md-7 col-xs-12"
                                   name="supportROM" value="${appInfo.supportROM}" required="required"
                                   data-validate-length-range="20" data-validate-words="1"
                                   placeholder="请输入支持的ROM" type="text" readonly="readonly">
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">界面语言 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input id="interfaceLanguage" class="form-control col-md-7 col-xs-12"
                                   data-validate-length-range="20" data-validate-words="1"  required="required"
                                   name="interfaceLanguage" value="${appInfo.interfaceLanguage}"
                                   placeholder="请输入软件支持的界面语言" type="text" readonly="readonly">
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="number">软件大小 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="number" id="softwareSize" name="softwareSize" value="${appInfo.softwareSize}" required="required"
                                   data-validate-minmax="10,500"  placeholder="请输入软件大小，单位为Mb" class="form-control col-md-7 col-xs-12" readonly="readonly">
                        </div>
                    </div>

                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="number">下载次数 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="number" id="downloads" name="downloads" value="${appInfo.downloads}" required="required"
                                   data-validate-minmax="10,500"  placeholder="请输入下载次数" class="form-control col-md-7 col-xs-12"readonly="readonly">
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12"  for="select">所属平台 <span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="hidden" value="${appInfo.flatformId}" id="fid" />
                            <input name="flatformId" id="flatformId" value="${appInfo.flatformName}" class="form-control" required="required" readonly="readonly">
                        </div>
                    </div>

                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="select">一级分类 <span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input name="categoryLevel1" id="categoryLevel1" class="form-control" value="${appInfo.cname1}>${appInfo.cname2}>${appInfo.cname3}"   required="required" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">APP状态 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input id="statusName" type="text" class="form-control col-md-7 col-xs-12"
                                   name="statusName" value="${appInfo.statusName}" readonly="readonly">
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="textarea">应用简介 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
              <textarea id="appInfo" name="appInfo" required="required"
                        placeholder="请输入本软件的相关信息，本信息作为软件的详细信息进行软件的介绍。" class="form-control col-md-7 col-xs-12" readonly="readonly">${appInfo.appInfo}</textarea>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">LOGO图片 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <div id="logoFile"><p><img src="${appInfo.logoPicPath}" width="100px;"/>
                                </p></div>

                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-6 col-md-offset-3">

                            <button id="send" type="submit" class="btn btn-success">保存</button>
                            <button type="button" class="btn btn-primary" id="back">返回</button>
                            <br/><br/>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
        <div class="x_title">
            <h2>新增版本信息</h2>
            <hr>
            <h2>历史版本列表</h2>

            <div class="clearfix"></div>
        </div>
        <div class="x_content">

            <div id="datatable-fixed-header_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">

                <div class="row"><div class="col-sm-12"><table id="datatable-fixed-header" class="table table-striped table-bordered dataTable no-footer" role="grid" aria-describedby="datatable-fixed-header_info"><thead>
                <tr role="row">
                    <th class="sorting_asc" tabindex="0" aria-controls="datatable-fixed-header" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 189px;">
                        软件名称</th>
                    <th class="sorting" tabindex="0" aria-controls="datatable-fixed-header" rowspan="1" colspan="1" aria-label="Start date: activate to sort column ascending" style="width: 140px;">
                        版本号</th>
                    <th class="sorting" tabindex="0" aria-controls="datatable-fixed-header" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending" style="width: 309px;">
                        版本大小（大小单位：M）</th><th class="sorting" tabindex="0" aria-controls="datatable-fixed-header" rowspan="1" colspan="1" aria-label="Office: activate to sort column ascending" style="width: 143px;">
                    发布状态</th><th class="sorting" tabindex="0" aria-controls="datatable-fixed-header" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending" style="width: 76px;">
                    APK文件下载</th><th class="sorting" tabindex="0" aria-controls="datatable-fixed-header" rowspan="1" colspan="1" aria-label="Start date: activate to sort column ascending" style="width: 140px;">
                    最新更新时间</th></tr>
                </thead>




                    <tbody>


                    <c:forEach items="${vlist}" var="v">
                        <tr role="row" class="odd">
                            <td class="sorting_1">${v.sName}</td>
                            <td>${v.versionNo}</td>
                            <td>${v.versionSize}</td>
                            <td>${v.dName}</td>
                            <td>${v.apkFileName}</td>
                            <td><fmt:formatDate value="${v.modifyDate}" pattern="yyyy-MM-dd"></fmt:formatDate></td>

                        </tr>
                    </c:forEach>



                    </tbody>
                </table>
                </div>
                </div>
                <div class="row">

                </div>
                <div class="col-sm-7"><div class="dataTables_paginate paging_simple_numbers" id="datatable-fixed-header_paginate"><ul class="pagination">
                </ul>
                </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="common/footer.jsp"%>
<script src="../statics/localjs/appinfoview.js"></script>
</body>
</html>
