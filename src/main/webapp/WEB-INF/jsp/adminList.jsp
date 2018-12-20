<%--
  Created by IntelliJ IDEA.
  User: 你爷
  Date: 2018/12/20
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>开发者</title>
</head>
<%@ include file="common/header.jsp"%>
<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="x_panel">
            <div class="x_title">
                <h2>App审核 <i class="fa fa-user"></i><small>${user.devName}你可以搜索、修改，和删除App</small></h2>
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
                                    <option value="0">--请选择--</option>
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
                                    <option value="0">--请选择--</option>
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
                                    <option value="0">--请选择--</option>
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

<%@ include file="common/footer.jsp"%>
</body>

</html>

