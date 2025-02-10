document.getElementById("sendBtn").addEventListener("click", function() {
    const userQuery = document.getElementById("userInput").value;
    if (userQuery.trim() === "") return;

    // Display user query in the chatbox
    const chatbox = document.getElementById("chatbox");
    chatbox.innerHTML += `<p class='user'><strong>You:</strong> ${userQuery}</p>`;

    // Send query to the server
    fetch('chatbot', {
        method: 'POST',
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
        body: `userQuery=${encodeURIComponent(userQuery)}`
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json();
    })
    .then(data => {
        // Display chatbot response in the chatbox
        chatbox.innerHTML += `<p class='bot'><strong>Bot:</strong> ${data.chatbotResponse}</p>`;
        chatbox.scrollTop = chatbox.scrollHeight;  // Scroll to the bottom
    })
    .catch(error => {
        console.error('Error:', error);
        chatbox.innerHTML += `<p class='bot'><strong>Bot:</strong> Oops! Something went wrong.</p>`;
    });

    // Clear input field after sending
    document.getElementById("userInput").value = "";
});
