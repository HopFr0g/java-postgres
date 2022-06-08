import {sendForm, deleteUser, getUsers} from "/scripts/reqManager.js";

const addEntryButton = document.querySelector(".add-entry__submit");
addEntryButton.addEventListener("click", () => {
    const addEntryUsername = document.querySelector(".add-entry__username");
    const addEntryEmail = document.querySelector(".add-entry__email");
    const addEntryDescription = document.querySelector(".add-entry__description");
    
    const username = addEntryUsername.value;
    const email = addEntryEmail.value;
    const description = addEntryDescription.value;
    
    sendForm(username, email, description);
});

const deleteEntry = id => {
    document.getElementById(`${id}`).remove();
}

const createEntry = userData => {
    // Element creation:
    const entry = document.createElement("div");
    const entryDelete = document.createElement("b");
    const entryUsername = document.createElement("h4");
    const entryEmail = document.createElement("h6");
    const entryDescription = document.createElement("p");
    
    // ID mapping:
    entry.id = parseInt(userData.id);
    
    // Class mapping:
    entry.classList.add("entry");
    entryDelete.classList.add("entry__delete");
    entryUsername.classList.add("entry__username");
    entryEmail.classList.add("entry__email");
    entryDescription.classList.add("entry__description");
    
    // Elements' funcionality:
    entryDelete.addEventListener("click", async () => {
        let confirmation = window.confirm(`Are you sure you want to remove the user ${userData.username} from the database?`);
        if (!confirmation)
            return;
        try {
            await deleteUser(userData.id);
            deleteEntry(userData.id);
        } catch (error) {
            console.error(error);
        }
    });
    
    // Text fill:
    entryDelete.innerHTML = "DELETE";
    entryUsername.innerHTML = userData.username;
    entryEmail.innerHTML = userData.email;
    entryDescription.innerHTML = userData.description;
    
    // Assembly:
    entry.appendChild(entryDelete);
    entry.appendChild(entryUsername);
    entry.appendChild(entryEmail);
    entry.appendChild(entryDescription);
    
    // End:
    return entry;
}

const loadEntries = async () => {
    try {
        const fragment = document.createDocumentFragment();
        
        let users = await getUsers();
        for (let user of users)
            fragment.appendChild(createEntry(user));
        
        document.querySelector(".main").appendChild(fragment);
    } catch (error) {
        console.error(error);
    }
}

loadEntries();