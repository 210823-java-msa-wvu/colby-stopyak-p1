



async function getUser() {
    let url = 'http://localhost:8080/colby-stopyak-p1h/users';

    let res = await fetch(url)
    let data = await res.json()

        .then(data => {
            console.log(data);
            // getting the data
            localStorage.setItem("emp_id", JSON.stringify(data.emp_id));
            localStorage.setItem("title", JSON.stringify(data.title));
        })
        .catch(err => console.log(err));

}