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
    <td>Post</td>
    <td>String name, String password, String email (not required)</td>
    <td>User</td>
  </tr>
</table>
<h3>Сущность Quote</h3>
<table>
  <thead>
    <td>Operation</td>
    <td>Endpoint</td>
    <td>Method</td>
    <td>Parameters</td>
    <td>Object</td>
  </thead>
  <tr>
    <td>findAll</td>
    <td>"/all"</td>
    <td>Get</td>
    <td></td>
    <td>List<Quote></td>
  </tr>
  <tr>
    <td>findById</td>
    <td>"/findById"</td>
    <td>Get</td>
    <td>int id</td>
    <td>Quote</td>
  </tr>
  <tr>
    <td>save</td>
    <td>"/save"</td>
    <td>Post</td>
    <td>String content, int userId</td>
    <td>Quote</td>
  </tr>
  <tr>
    <td>update</td>
    <td>"/update"</td>
    <td>int quoteId, String content</td>
    <td>Post</td>
    <td>Quote</td>
  </tr>
  <tr>
    <td>delete</td>
    <td>"/delete"</td>
    <td>int id</td>
    <td>Get</td>
    <td>Quote</td>
  </tr>
  <tr>
    <td>top ten</td>
    <td>"/top_ten"</td>
    <td></td>
    <td>Get</td>
    <td>LinkedList<QuoteDTO></td>
  </tr>
  <tr>
    <td>worst ten</td>
    <td>"/worst_ten"</td>
    <td></td>
    <td>Get</td>
    <td>LinkedList<QuoteDTO></td>
  </tr>
  <tr>
    <td>random</td>
    <td>"/random"</td>
    <td></td>
    <td>Get</td>
    <td>Quote</td>
  </tr>
</table>
