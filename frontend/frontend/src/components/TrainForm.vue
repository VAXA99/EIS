<template>
  <div>
    <h2>Добавить/Обновить поезд</h2>
    <form @submit.prevent="submitTrain">
      <input
          v-model="train.name"
          placeholder="Название поезда"
          required
      />
      <input
          v-model="train.number"
          placeholder="Номер поезда"
          required
      />
      <label>
        Активен:
        <input
            type="checkbox"
            v-model="train.is_active"
            @change="updateIsActive"
        />
      </label>
      <button type="submit">Сохранить</button>
    </form>
  </div>
</template>

<script>
import trainService from "@/services/trainService";

export default {
  data() {
    return {
      train: {
        id: null,
        name: "",
        number: "",
        is_active: false,
      },
    };
  },
  methods: {
    updateIsActive(event) {
      this.train.is_active = event.target.checked || false;
    },
    async submitTrain() {
      this.train.is_active = !!this.train.is_active;
      if (this.train.id) {
        await trainService.updateTrain(this.train);
      } else {
        await trainService.addTrain(this.train);
      }
      this.clearForm();
      this.$emit("refresh");
    },
    clearForm() {
      this.train = {
        id: null,
        name: "",
        number: "",
        is_active: false,
      };
    },
    editTrain(train) {
      this.train = {...train};
    },
  },
};
</script>
