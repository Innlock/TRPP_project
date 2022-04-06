<template>
    <div class="book">
        <div style="margin-bottom: 20px">
            <div class="title">{{book.title}}</div>
            <div class="author">{{book.author}}</div>
        </div>
        <div class="book_buttons">
            <button class="more_button">Подробнее</button>
            <button class="change_button">Изменить</button>
            <button class="delete_button">Удалить</button>
        </div>
    </div>
</template>

<script>
    export default {
        props: {
            book: {
                type: Object,
                required: true
            }
        },
        methods: {
            
        }
    }
</script>

<style scoped>
    .title {
        font-size: 1.3em;
        background: #fff;
    }

    .author {
        font-size: 1.05em;
        color: #767384;
        background: #fff;
    }

    .book {
        padding: 15px;
        padding-bottom: 20px;
        padding-top: 20px;
        margin: 1.5%;
        margin-top: 0;
        margin-bottom: 20px;
        min-width: 250px;
        border-radius: 5px;
        background: #fff;
        text-align: center;
        break-inside: avoid;
    }
    .book_buttons {
        position: relative;
        top: 10px;
    }
    .delete_button {
        padding: 6px;
        margin: 0.75%;
        width: 30%;
        border-radius: 5px;
        border: none;
        background: #e3d9e4;
        color: #000;
    }
    .change_button {
        padding: 6px;
        margin: 0.75%;
        width: 30%;
        border-radius: 5px;
        border: none;
        background: #e3d9e4;
        color: #000;
    }
    .more_button {
        padding: 6px;
        margin: 0.75%;
        width: 30%;
        border-radius: 5px;
        border: none;
        background: #767384;
        color: #f9f1ef;
    }
    .book_img {
        border-radius: 5px;
        height: 50%;
        width: 50%;
        margin: 10px;
    }
</style>