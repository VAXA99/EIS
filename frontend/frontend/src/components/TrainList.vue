<template>
  <div>
    <h2>Список активных поездов</h2>
    <ul>
      <li v-for="train in trains" :key="train.id">
        {{ train.name }} ({{ train.number }}) - Активен: {{ train.is_active ? "Да" : "Нет" }}
        <button @click="$emit('edit', train)">Редактировать</button>
        <button @click="deleteTrain(train.id)">Удалить</button>
      </li>
    </ul>
  </div>
</template>

<script>
import trainService from "@/services/trainService";

export default {
  data() {
    return {
      trains: [],
    };
  },
  methods: {
    async fetchTrains() {
      this.trains = (await trainService.getActiveTrains()).data;
    },
    async deleteTrain(id) {
      await trainService.deleteTrain(id);
      this.fetchTrains();
    },
  },
  mounted() {
    this.fetchTrains();
  },
};
</script>
