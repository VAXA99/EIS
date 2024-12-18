<template>
  <div>
    <h2>Добавить/Обновить поезд</h2>
    <form @submit.prevent="submitTrain">
      <input v-model="train.name" placeholder="Название поезда" required/>
      <input v-model="train.number" placeholder="Номер поезда" required/>
      <label>
        Активный:
        <input type="checkbox" v-model="train.isActive"/>
      </label>
      <button type="submit">Сохранить</button>
    </form>
  </div>
</template>

<script>
import trainService from '@/services/trainService';

export default {
  data() {
    return {
      train: {
        id: null,
        name: '',
        number: '',
        isActive: false,
      },
    };
  },
  methods: {
    async submitTrain() {
      if (this.train.id) {
        await trainService.updateTrain(this.train);
      } else {
        await trainService.addTrain(this.train);
      }
      this.clearForm();
    },
    clearForm() {
      this.train = {id: null, name: '', number: '', isActive: false};
    },
  },
};
</script>
