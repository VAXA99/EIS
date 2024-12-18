<template>
  <div>
    <h2>Список активных поездов</h2>
    <ul>
      <li v-for="train in trains" :key="train.id">
        {{ train.name }} ({{ train.number }})
        <span v-if="train.isActive">[Активный]</span>
        <button @click="deleteTrain(train.id)">Удалить</button>
      </li>
    </ul>
  </div>
</template>
<script>
import trainService from '@/services/trainService';

export default {
  data() {
    return {
      trains: [],
    };
  },
  methods: {
    async fetchTrains() {
      const response = await trainService.getTrains();
      this.trains = response.data;
    },
    async deleteTrain(id) {
      await trainService.deleteTrain(id);
      this.fetchTrains();
    },
  },
  created() {
    this.fetchTrains();
  },
};
</script>
