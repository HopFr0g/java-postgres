const sendForm = (username, email, description) => {
    const body = {username, email, description};
    
    const settings = {
        method: "POST",
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(body)
    };
    
    fetch("/users", settings).then(() => location.reload()).catch(error => console.error(error));
}

const deleteUser = id => {
    return new Promise(async (resolve, reject) => {
        try {
            await fetch(`/users/${id}`, {method: "DELETE"});
            return resolve();
        } catch (error) {
            return reject(error);
        }
    });
}

const getUsers = (id) => {
    return new Promise(async (resolve, reject) => {
        try {
            let req = await fetch(`/users`);
            let res = await req.json();
            return resolve(res);
        } catch (error) {
            return reject(error);
        }
    });
}

export {sendForm, deleteUser, getUsers};