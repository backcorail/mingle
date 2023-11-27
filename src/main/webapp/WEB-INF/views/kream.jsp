<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
    <table class= "table">
        <tr>
            <th>이미지</th>
            <th>제목</th>
        </tr>
        <tr th:each="kream : ${kreams} ">
            <td><a th:href="${kream.url}"><img th:src="${kream.image}"></a></td>
            <td><a th:href="${kream.url}"><span th:text="${kream.subject}"></span></a></td>
            </a>
        </tr>
    </table>
</div>