<template>
    <form @submit.prevent>
        <h2>Добавить книгу</h2>
        <input 
               v-model="book.title"
               class="input"
               type="text"
               placeholder="Название" />
        <input 
               v-model="book.author"
               class="input"
               type="text"
               placeholder="Автор" />
        <button class="button" @click="createBook">Добавить</button>
    </form>
</template>

<script>
    export default {
        data() {
            return {
                book: {
                    'title': '',
                    'author': ''
                }
            }
        },
        methods: {
            createBook() {
                id: Date.now(),
                this.$emit('create', this.book)
                this.post = {
                    title: '',
                    author: ''
                }
            }
        }
    }

</script>

<style>
    .input {
        width: 25%;
        margin: 1.5%;
        padding: 8px;
        border-radius: 5px;
        border: none;
        margin-left: 0;
    }
    .button {
        padding: 8px;
        margin: 0.75%;
        width: 6%;
        min-width: 80px;
        border-radius: 5px;
        border: none;
        background: #767384;
        color: #f9f1ef;
    }
</style>