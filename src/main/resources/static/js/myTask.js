
let url = "me";

fetch(url)
  .then(response => response.json())
  .then(tasks => {
    let tableRows = tasks.map(task =>
        `<tr><td>${task.date}</td>` +
            `<td>${task.description}</td>` +
            `<td>${task.done}</td></tr>`);

    let tasksTable = document.getElementById('tasksTable');
    for(let tableRow of tableRows) {
        tasksTable.innerHTML += tableRow;
    }
  });