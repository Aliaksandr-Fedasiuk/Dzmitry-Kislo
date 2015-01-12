<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
  table.reference tr:nth-child(even) {
    background-color: #ffffff;
    border: 1px solid #000;
  }
  tbody {
    display: table-row-group;
    vertical-align: middle;
    border-color: inherit;
  }
  table.reference tr:nth-child(odd) {
    background-color: #f1f1f1;
  }
  tr {
    display: table-row;
    vertical-align: inherit;
    border-color: inherit;
  }
</style>
<div style="margin: 10px;">
  <h4>List of Users</h4>
  <table style="width: 600px" class="reference">
    <tbody>
    <tr>
      <th>Id</th>
      <th>Login</th>
      <th>Name</th>
    </tr>
    <c:forEach var="user" items="${users}">
      <tr>
        <td><c:out value="${user.userId}" /></td>
        <td><c:out value="${user.login}" /></td>
        <td><c:out value="${user.name}" /></td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>