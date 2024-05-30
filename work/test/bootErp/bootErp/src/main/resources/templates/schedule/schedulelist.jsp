<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Example</title>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
  <div style="padding-top: 30px">
        <h2>일정목록</h2>

     <div class="input-group mb-3" style="margin-top:20px;">
          <select  class="form-select-sm btn-primary " id="searhKey" name="searchKey">
            <option value="all">선택하세요</option>
            <option value="1">1월</option>
            <option value="2">2월</option>
            <option value="3">3월</option>
            <option value="4">4월</option>
            <option value="5">5월</option>
            <option value="6">6월</option>
            <option value="7">7월</option>
            <option value="8">8월</option>
            <option value="9">9월</option>
            <option value="10">10월</option>
            <option value="11">11월</option>
            <option value="12">12월</option>
          </select>
          
            <input type="text" class="form-control" placeholder="Search">
            <button class="btn btn-secondary" type="submit">Go</button>
          </div>

        
          <table class="table table-hover ">
          
            <thead class="table-secondary">
              <tr>
                <th>번호</th>
                <th>스케쥴명</th>
                <th>분류</th>
                <th>스케쥴진행날짜</th>
                <th>진행상황</th>
                <th>삭제</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="schedule" items="${schedulelist }">
					<tr>
						<td>${schedule.scheduleId }</td>
						<td><a href="/erp/schedule/read?scheduleId=${schedule.scheduleId }&action=READ">${schedule.title }</a></td>
						<td>${schedule.category }</td>
						<td>${schedule.scheduleDay }</td>
						<td>${schedule.place }</td>
							<c:if test="${schedule.scheduleId == schedule.scheduleId }">
								<td><a href="/erp/schedule/delete?scheduleId=${schedule.scheduleId }">삭제</a>${schedule.scheduleId}</td>
							</c:if>
					</tr>
				</c:forEach>
            </tbody>
          </table>

 
          <ul class="pagination  justify-content-center">
            <li class="page-item disabled"><a class="page-link" href="#">first</a></li>
            <li class="page-item disabled"><a class="page-link" href="#">Previous</a></li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item"><a class="page-link" href="#">4</a></li>
            <li class="page-item"><a class="page-link" href="#">5</a></li>
            <li class="page-item"><a class="page-link" href="#">Next</a></li>
            <li class="page-item"><a class="page-link" href="#">last</a></li>
          </ul>
       
          <div class="container mt-3" style="text-align:right;">
            <a href="/erp/schedule/insert" class="btn btn-secondary">일정등록</a>
          
          </div>
          
    </div>
</body>
</html>