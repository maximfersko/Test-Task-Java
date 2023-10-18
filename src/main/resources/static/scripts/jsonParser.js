document.getElementById('file-input').addEventListener('change', function(event) {
    var file = event.target.files[0];

    if (!file) {
        return;
    }

    var reader = new FileReader();
    reader.onload = function(e) {
        var content = e.target.result;
        try {
            var data = JSON.parse(content);

            document.getElementById('expression').value = data.numbers;

            document.querySelector(`input[name="operation"][value="${data.operation}"]`).checked = true;

            evaluateExpression();
        } catch (error) {
            console.error('Error parsing JSON:', error);
        }
    };

    reader.readAsText(file);
});
