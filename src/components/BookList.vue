<template>
    <div>
        <h3>Мои книги</h3>
        <div class="book_table">
            <book v-for="book in books"
                  :book="book" />
        </div>

    </div>
</template>

<script>
    import Book from "./Book";
    import DeleteButton from "./DeleteButton";

    export default {
        components: {Book, DeleteButton},
        props: {
            books: {
                type: Array,
                required: true
            }
        }
    }
</script>

<style scoped>
    .book_table {
        column-count: 3;
        column-gap: 10px;
        margin-top: 20px;
    }
</style>