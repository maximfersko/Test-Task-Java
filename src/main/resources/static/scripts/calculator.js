document.getElementById("calculator-form").addEventListener("submit", function(event){
    event.preventDefault();
    evaluateExpression();
});

function evaluateExpression() {
    let expressionInput = document.getElementById("expression");
    let expression = expressionInput.value.trim();
    let operation = document.querySelector('input[name="operation"]:checked').value;

    if (expression === '' || !operation) {
        document.getElementById('result').textContent = 'Error';
        return;
    }

    fetch('/calculate', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
        },
        body: new URLSearchParams({
            numbers: expression,
            operation: operation
        }),
    })
    .then((response) => response.text())
    .then((data) => {
        document.getElementById('result').textContent = data;
    })
    .catch((error) => {
        document.getElementById('result').textContent = 'Error';
    });
}
