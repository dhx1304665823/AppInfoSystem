<%--
  Created by IntelliJ IDEA.
  User: 你爷
  Date: 2018/12/19
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>开发者</title>
</head>
<link rel="stylesheet" href="../statics/localcss/appinfolist.css" type="text/css">
<%@ include file="common/header.jsp"%>

<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="x_panel">
            <div class="x_title">
                <h2>App信息管理维护 <i class="fa fa-user"></i><small>${user.devName}你可以搜索、修改，和删除App</small></h2>
                <ul class="nav navbar-right panel_toolbox">
                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                    </li>

                </ul>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">
                <br />

                <form id="demo-form2" data-parsley-validate class="form-horizontal form-label-left" action="list">
                    <ul>
                        <li>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">软件名称 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" id="first-name" class="form-control col-md-7 col-xs-12" name="softwareName" value="${softwareName}">
                        </div>
                    </div>
                        </li><li>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">App状态 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <select name="status" class="form-control">
                                <option value="">--请选择--</option>
                                <c:forEach items="${dictionaryList}" var="dlist">
                                    <option value="${dlist.valueId}"  <c:if test="${statuss==dlist.valueId}">selected="selected"</c:if>>${dlist.valueName}</option>
                                </c:forEach>
                            </select>

                        </div>
                    </div>
                    </li><li>
                    <div class="form-group">
                        <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">所属平台</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <select name="flatformId" class="form-control">
                                <option value="">--请选择--</option>
                                  <c:forEach items="${dictionaryList2}" var="dlist">
                                      <option value="${dlist.valueId}" <c:if test="${flatformIds==dlist.valueId}">selected="selected"</c:if>>${dlist.valueName}</option>

                                  </c:forEach>
                            </select>
                        </div>
                    </div>
                    </li><li>
                    <div class="form-group">
                        <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">一级分类</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <select name="categoryLevel1" class="form-control" id="categoryLevel1">
                                <option value="">--请选择--</option>
                                <c:forEach items="${categoryList}" var="cList">
                                    <option value="${cList.id}" <c:if test="${categoryLevel1s==cList.id}">selected="selected"</c:if>>${cList.categoryName}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    </li><li>
                    <div class="form-group">
                        <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">二级分类</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <select name="categoryLevel2" class="form-control" id="categoryLevel2">
                                <option value="0">--请选择--</option>

                            </select>
                        </div>
                    </div>
                    </li><li>
                    <div class="form-group">
                        <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">三级分类</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <select name="categoryLevel3" class="form-control" id="categoryLevel3">
                                <option value="0">--请选择--</option>

                            </select>
                        </div>
                    </div>

                    </li><li>
                    <div class="ln_solid"></div>
                    <div class="form-group">
                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">

                            <button type="submit" class="btn btn-success">搜索</button>
                        </div>
                    </div>
                    </li>
                    </ul>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="x_panel">
            <div class="x_title">
                <a href="add" class="btn btn-success btn-sm">新增APP基础信息</a>

                <ul class="nav navbar-right panel_toolbox">
                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                    </li>

                </ul>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">

                <table id="datatable" class="table table-striped table-bordered">
                    <thead>
                    <tr>
                        <th>软件名称</th>
                        <th>APK名称</th>
                        <th>软件大小（单位：M）</th>
                        <th>所属平台</th>
                        <th>所属分类（一级分类，二级分类，三级分类）</th>
                        <th>状态</th>
                        <th>下载次数</th>
                        <th>最新版本号</th>
                        <th>操作</th>
                    </tr>
                    </thead>


                    <tbody>
                    <c:forEach items="${appInfoList}" var="app">
                        <tr>
                            <td>${app.softwareName}</td>
                            <td>${app.APKName}</td>
                            <td>${app.softwareSize}</td>
                            <td>${app.flatformName}</td>
                            <td>${app.cname1}->${app.cname2}->${app.cname3}</td>
                            <td>${app.statusName}</td>
                            <td>${app.downloads}</td>
                            <td>${app.versionName}</td>
                            <td><div class="btn-group">
                                <button type="button" class="btn btn-danger">点击操作</button>
                                <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                                    <span class="caret"></span>
                                    <span class="sr-only">Toggle Dropdown</span>
                                </button>
                                <ul class="dropdown-menu" role="menu">
                                        <li>

                                    <c:choose>
                                        <c:when test="${app.status == 2 || app.status == 5}">
                                            <a class="saleSwichOpen" saleSwitch="open" appinfoid=${app.id }  appsoftwarename=${app.softwareName } data-toggle="tooltip" data-placement="top" title="" data-original-title="恭喜您，您的审核已经通过，您可以点击上架发布您的APP">上架</a>
                                        </c:when>
                                        <c:when test="${app.status == 4}">
                                            <a class="saleSwichClose" saleSwitch="close" appinfoid=${app.id }  appsoftwarename=${app.softwareName } data-toggle="tooltip" data-placement="top" title="" data-original-title="您可以点击下架来停止发布您的APP，市场将不提供APP的下载">下架</a>
                                        </c:when>
                                    </c:choose>

                                    <li><a href="../version/addlist?id=${app.id}">新增版本</a></li>
                                    </li>

                                        <li><a href="../version/updlist?id=${app.id}&vid=${app.versionId}">修改版本</a></li>



                                    <li><a class="modifyAppInfo" appinfoid="${app.id}" statusname="${app.statusName}" status="${app.status}">修改</a></li>

                                    <li><a href="#">查看</a></li>

                                    <li><a href="#">删除</a></li>

                                    <li class="divider"></li>
                                    <li><a href="#">Separated link</a>
                                    </li>
                                </ul>
                            </div></td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
                <b>共${count}条数据 ${pageNo}/${yeSize}页</b>
                <div class="dataTables_paginate paging_simple_numbers" id="datatable_paginate">
                    <ul class="pagination">
                        <c:if test="${pageNo>1}">
                            <li class="paginate_button next" id="datatable_last"><a href="list?pageNo=${pageNo-1}" aria-controls="datatable" data-dt-idx="7" tabindex="0">上一页</a></li>
                        </c:if>


                            <li class="paginate_button"><a href="#" aria-controls="datatable" data-dt-idx="${pageNo}" tabindex="0">${pageNo}</a></li>




                        </li>
                        <c:if test="${pageNo<yeSize}">
                            <li class="paginate_button next" id="datatable_next"><a href="list?pageNo=${pageNo+1}" aria-controls="datatable" data-dt-idx="7" tabindex="0">下一页</a></li>
                        </c:if>

                    </ul>
                </div>

            </div>
            </div>

    </div>
</div>

<%@ include file="common/footer.jsp"%>
<script src="../statics/localjs/applist.js"></script>
<script src="../statics/localjs/appinfolist.js"></script>
</body>

</html>

