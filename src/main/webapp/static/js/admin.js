
function updateManager() {
    console.log("clicking add")

    // console.log(document.getElementById('status').value);
    // console.log(document.getElementById('rm_id').value);
    // console.log(document.getElementById('emp_id').value);
    let rm_idInput = document.getElementById('rm_id').value;
    console.log(rm_idInput);
    let data = {
        rm_id: rm_idInput,
        user: {emp_id: localStorage.getItem('emp_id')},
        
        // description: document.getElementById('description').value,
        // location: document.getElementById('location').value,
        // amount: document.getElementById('amount').value,
        // work_related: document.getElementById('work_related').value,
        status: document.getElementById('status').value,
        
        is_approved: false

    }
    console.log(status);
    // console.log("desciption" + descriptionI)
    console.log(JSON.stringify(data));
    // console.log(newForm);
   

    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            let resp = this.responseText;
            console.log(resp);
        }
    }
    let url = 'http://localhost:8080/colby-stopyak-p1h/reimbursement/';
    // xhttp.open('PUT', url + rm_idInput, true)
    
    
    
    xhttp.open('PUT', url + rm_idInput, true);
    xhttp.setRequestHeader('Content-Type', 'application/json');
    // // xhttp.send(newForm);
    xhttp.send(JSON.stringify(data));

    
    
}

// async function updateM(){
//     console.log("click updatem")
//     let url = 'http://localhost:8080/colby-stopyak-p1h/reimbursement/';

//     let rm_idInput = document.getElementById('rm_id').value;

//     let data = {
//         rm_id: rm_idInput,
//         user: {emp_id: localStorage.getItem('emp_id')},
        
//         // description: document.getElementById('description').value,
//         // location: document.getElementById('location').value,
//         // amount: document.getElementById('amount').value,
//         // work_related: document.getElementById('work_related').value,
//         status: document.getElementById('status').value,
        
//         is_approved: false

//     }
//     let res = await fetch(url + rm_idInput, {
//         method: "PUT",
//         headers: {"Content-Type": "application/json"},
//         body: JSON.stringify(data)
//     });

// }


// var req;
// const idArray = [];
// getReq();
// idList();

// function get(){
//     let xhttp = new XMLHttpRequest();

//     xhttp.onreadystatechange = function() {
//         console.log("state ready" + this.readyState);


//         if(this.readyState == 4 && this.status == 200){

//             req = JSON.parse(this.responseText)
//             console.log(req);


//             const tableRow = document.getElementById("tableRow")
//             tableRow.innerHTML = "";
//             req.array.forEach(res => {
//                 idArray.push(res.id);

//                 const content = `
//                     <tr>
//                         <th scope="row> ${res.id}> </th>
//                         <td> ${res.user.username} </td>
//                         <td> ${res.rm_id} </td>
//                         <td> ${res.description} </td>
//                         <td> ${res.location} </td>
//                         <td> ${res.amount} </td>
//                         <td> ${res.work_related} </td>
//                         <td> ${res.status} </td>
//                         <td> ${res.is_approved} </td>
//                         <td> ${res.user.emp_id} </td>
//                     </tr>
                
                
//                 `
//                 tableRow.innerHTML += content;
//             })
//         }
//     }

//     let url = `http://localhost:8080/colby-stopyak-p1h/reimbursement`

//     //step3
//     xhttp.open("GET", url, true);

//     //step4
//     xhttp.send();

// }


function table(){
    var body = document.body,
    table = document.createElement('table');

    let row= table.insertRow();
    let tableData = data[0];
    for(key in tableData){
        var th =row.insertCell();
        th.appendChild(document.createTextNode(key));

    }
    for(let element of data){
        var rows = table.insertRow();
        for( key in element){
            var tableD = row.insertCell();
            tableD.appendChild(document.createTextNode(element[key]));
        }
    }
    body.append(table);
}

function getReimbursements(){
    console.log('click')
    let url = 'http://localhost:8080/colby-stopyak-p1h/reimbursement';
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = receiveData;

    function receiveData(){
        if(this.readyState == 4){
            let response = this.responseText;
            console.log(response);

            response = Json.parse(response);
            table(response);

        }
    }
    xhttp.open('GET', url, true)
    xhttp.send();
}

// function populateData(res) {

//     // This is where we will do our DOM manipulation
//     let dataSection = document.getElementById('data');

//     // Create a new element
//     let nameTag = document.createElement('h3');

//     // Add text to the inner html of the new element
//     // <h3>innerHtml</h3>
//     nameTag.innerHTML = res.rm_id;

//     // Append this new element to the section element (adding it as a child node in the DOM)
//     dataSection.appendChild(nameTag);


//     // Now we'll use the same process for the Abilities
//     let abilitiesArray = res.abilities;
//     console.log(abilitiesArray);

//     /**
//      * <ul>
//      *    <li>"Ability Name"</li>
//      *    <li>"Ability Name"</li>
//      *    <li>"Ability Name"</li>
//      * </ul>
//      */

//     // Create an unordered list element
//     let abilities = document.createElement('ul');
//     dataSection.innerHTML += 'Abilities<br>';
//     dataSection.appendChild(abilities);

//     // Iterate over the abilities array and create 'li' elements
//     for (let ability of abilitiesArray) { // for-of -> iterate over the elements inside the array
//         let abli = document.createElement('li');
//         abli.innerHTML = (ability.ability.name);
//         abilities.appendChild(abli);
//     }

   
    
    
// }

// async function getReimbursementsFetch() {

//     let url = 'http://localhost:8080/colby-stopyak-p1h/reimbursement';
//     let res = await fetch(url)
//     let data = await res.json()

//     // the promise method then()
//     .then(data => {
//         console.log(data);
//         table(data);
//     })
//     .catch(err => console.log(err));

// }

// function populateData(res) {

//     let lineBreak = document.createElement("br");
//     let dataSection = document.getElementById('data');
//     let nameTag = document.createElement('h3');

//     nameTag.innerHTML += "<br>REIMBURSEMENTS:";
//     dataSection.appendChild(nameTag);
//     dataSection.appendChild(nameTag);

//     let dataTag = document.createElement('p');

//     for(let i = 0; i < res.length; i++) {
//         let formData = document.createElement("p");

        

//     }    


        
// }
