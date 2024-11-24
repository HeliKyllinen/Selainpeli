const style = document.createElement('style');
style.innerHTML = `
    body {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
        background-color: #f0f0f0;
    }

    h1 {
        margin-bottom: 20px;
    }

    #puzzleContainer {
        display: none;
        grid-template-columns: repeat(4, 1fr);
        grid-template-rows: repeat(4, 1fr);
        gap: 1px;
        position: relative;
        border: 2px solid #333;
        background-image: linear-gradient(to right, #333 1px, transparent 1px),
            linear-gradient(to bottom, #333 1px, transparent 1px);
        background-size: calc(100% / 4) calc(100% / 4);
        overflow: hidden;
    }

    .puzzlePiece {
        position: absolute;
        border: 1px solid #333;
        cursor: pointer;
        width: 100px;
        height: 100px;
        z-index: 1;
    }

    #searchSection {
        margin-bottom: 20px;
    }

    #completedMessage {
        display: none;
        margin-top: 20px;
        font-size: 24px;
        color: green;
    }

    #playerCount {
        position: fixed;
        top: 10px;
        right: 10px;
        background: rgba(255, 255, 255, 0.9);
        padding: 5px 10px;
        border-radius: 5px;
        font-size: 16px;
        font-weight: bold;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    }

    #statsBox {
        position: fixed;
        top: 10%;
        right: 10px;
        width: 250px;
        background: #ffffff;
        border: 1px solid #ddd;
        border-radius: 10px;
        padding: 15px;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        text-align: left;
        font-family: Arial, sans-serif;
    }

    #statsBox h2 {
        font-size: 18px;
        margin: 0 0 10px;
        color: #333;
    }

    #statsBox p {
        margin: 5px 0;
        font-size: 14px;
        color: #555;
    }
`;
document.head.appendChild(style);
