<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<body>
<div class="container mt-5">
    <!-- HTML-код модального окна -->
    <div id="myModalBox" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <!-- Заголовок модального окна -->
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h4 class="modal-title">Заголовок модального окна</h4>
                </div>
                <!-- Основное содержимое модального окна -->
                <div class="modal-body">
                    Содержимое модального окна...
                </div>
                <!-- Футер модального окна -->
                <div class="modal-footer">
                    <a href="#" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Primary link</a>
                    <a href="/download2" class="btn btn-secondary btn-lg active" role="button"
                       aria-pressed="true">Link</a>
                </div>
            </div>
        </div>
    </div>

    <!-- Скрипт, вызывающий модальное окно после загрузки страницы -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    <script>
        $(document).ready(function () {
            $("#myModalBox").modal('show');
        });
    </script>
</div>
</body>
</html>