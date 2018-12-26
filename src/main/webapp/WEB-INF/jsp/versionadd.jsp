<%--
  Created by IntelliJ IDEA.
  User: 你爷
  Date: 2018/12/22
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<%@include file="common/header.jsp"%>
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



                  <c:forEach items="${vlist}" var="v">
                      <tr role="row" class="odd">
                          <td class="sorting_1">${v.sName}</td>
                          <td>${v.versionNo}</td>
                          <td>${v.versionSize}</td>
                          <td>${v.dName}</td>
                          <td>${v.apkFileName}</td>
                          <td>${v.modifyDate}</td>

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
</div>
<div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
        <div class="x_content" style="display: block;">
            <br>
            <form class="form-horizontal form-label-left" action="../version/addVersion" method="post" enctype="multipart/form-data">
               <input type="hidden" name="appId" value="${appid}">
               <div class="item form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="versionNo">版本号 <span class="required">*</span>
                    </label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <input id="versionNo" class="form-control col-md-7 col-xs-12"
                               data-validate-length-range="20" data-validate-words="1" name="versionNo"
                               placeholder="请输入版本号" type="text"  required="required" value="">
                    </div>
                </div>
                <div class="item form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="versionSize">版本大小 <span class="required">*</span>
                    </label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <input type="number" id="versionSize" name="versionSize"  required="required"
                               data-validate-minmax="10,500" value=""  placeholder="请输入版本大小，单位为Mb" class="form-control col-md-7 col-xs-12">
                    </div>
                </div>

                <div class="item form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12"  for="publishStatus">发布状态 <span class="required">*</span></label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <input type="hidden" name="publishStatus" id="publishStatus" value="3">预发布
                    </div>
                </div>

                <div class="item form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="versionInfo">版本简介 <span class="required">*</span>
                    </label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
              <textarea id="versionInfo" name="versionInfo" required="required"
                        placeholder="请输入本版本的相关信息，本信息作为该版本的详细信息进行版本介绍。" class="form-control col-md-7 col-xs-12"></textarea>
                    </div>
                </div>--%>
             <div class="item form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="a_downloadLink">apk文件 <span class="required">*</span>
                    </label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <input type="file" class="form-control col-md-7 col-xs-12" name="a_downloadLink" id="a_downloadLink" />
                        ${fileUploadError }
                    </div>
                </div>
                <div class="ln_solid"></div>
                <div class="form-group">
                    <div class="col-md-6 col-md-offset-3">
                        <button id="send" type="submit" class="btn btn-success">保存</button>
                        <button type="button" class="btn btn-primary" id="back">返回</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<%@include file="common/footer.jsp"%>
</body>
</html>
