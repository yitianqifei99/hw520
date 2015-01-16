<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Golden Eagle Flight Plan: Add Stage</title>
    <c:import url="../style.jsp"></c:import>
</head>
<body>
<h2>Golden Eagle Flight Plan</h2>

<h3><a href="/gefp">Golden Eagle Flight Plan</a> - Add A Stage</h3>

<div class="region">
<form method="post" action="/gefp/addStage">
    <table>
        <tbody>
        <tr>
            <th scope="row" >Stage:</th>
            <td><input name="stage" /></td>
        </tr>
        <tr>
            <td colspan="2" scope="row"><input name="add" type="submit" value="Add" /></td>
        </tr>
        </tbody>
    </table>
</form>
</div>

</body>
</html>
