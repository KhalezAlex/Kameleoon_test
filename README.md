<h1>
Тестовое задание (компания Kameleoon)
</h1>
</br>
<h2>
  Задача:
</h2>
Подготовить api для работы с сервисом цитат. Он должен осуществлять следующие операции:
<ol>
  <li>
    Для сущности Пользователь:
    <ol>
      <li>
        операция создания аккаунта
      </li>
    </ol>
  </li>
  <li>
    Для сущности Цитата:
    <ol>
      <li>
        операция сохранения
      </li>
      <li>
        операция изменения
      </li>
      <li>
        операция удаления
      </li>
      <li>
        операции доступа к данным (включая получение случайной цитаты)
      </li>
      <li>
        возвращать топ 10 цитат и 10 худших цитат
      </li>
    </ol>
  </li>
  <li>
    Для сущности Голос
    <ol>
      <li>
        операция голосования (up/down)
      </li>
    </ol>
  </li>
</ol>
</br>
<h2>Описание API</h2>
<h3>Сущность User</h3>
<table>
  <thead>
    <td>Operation</td>
    <td>Endpoint</td>
    <td>Method</td>
    <td>Parameters</td>
    <td>Object</td>
  </thead>
  <tr>
    <td>save</td>
    <td>"/save"</td>
    <td>String name, String password, String email (not required)</td>
    <td>Post</td>
    <td>User</td>
  </tr>
</table>
