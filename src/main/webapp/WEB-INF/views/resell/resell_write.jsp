<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="/mingle/css/resell/resell_write.css">
<script src="/mingle/js/resell/resell_write.js"></script>

<script src="https://cdn.tiny.cloud/1/no-api-key/tinymce/6/tinymce.min.js" referrerpolicy="origin"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
    <script
      src="https://code.jquery.com/jquery-3.6.0.min.js"
      integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
      crossorigin="anonymous"
    ></script>
    <script
      src="https://cdn.tiny.cloud/1/no-api-key/tinymce/6/tinymce.min.js"
      referrerpolicy="origin"
    ></script>
    <script src="https://cdn.jsdelivr.net/npm/@tinymce/tinymce-jquery@2/dist/tinymce-jquery.min.js"></script>
  </head>
  <body>
    <div>
      <textarea id="tiny">&lt;p&gt;Welcome to the TinyMCE jQuery example!&lt;/p&gt;</textarea>
    </div>
    <script>
      $('textarea#tiny').tinymce({
        height: 500,
        menubar: false,
        plugins: [
          'advlist', 'autolink', 'lists', 'link', 'image', 'charmap', 'preview',
          'anchor', 'searchreplace', 'visualblocks', 'fullscreen',
          'insertdatetime', 'media', 'table', 'code', 'help', 'wordcount'
        ],
        toolbar: 'undo redo | blocks | bold italic backcolor | ' +
          'alignleft aligncenter alignright alignjustify | ' +
          'bullist numlist outdent indent | removeformat | help'
      });
    </script>