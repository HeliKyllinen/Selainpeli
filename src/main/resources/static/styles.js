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
        display: grid;
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
`;
document.head.appendChild(style);
